#!/usr/bin/env bash

install_from_gh() {
  local variant=$1
  local dest_dir=$2
  local exe=$3
  
  # Fetch latest release tag name using grep and sed to avoid dependency on jq
  local ver=$(curl -sL 'https://api.github.com/repos/mozilla/sccache/releases/latest' | grep '"tag_name":' | sed -E 's/.*"tag_name":\s*"([^"]+)".*/\1/')
  
  if [ -z "$ver" ]; then
    echo "Warning: Could not fetch sccache version"
    return 1
  fi
  
  local url="https://github.com/mozilla/sccache/releases/download/${ver}/sccache-${ver}-${variant}.tar.gz"
  local dest="${dest_dir}/${exe}"
  
  echo "Downloading sccache ${ver} from ${url}..."
  mkdir -p "${dest_dir}"
  
  if curl -L "$url" | tar xz -O --wildcards "*/${exe}" > "${dest}"; then
    chmod +x "${dest}"
    echo "sccache successfully installed to ${dest}"
    return 0
  else
    echo "Warning: Failed to download/extract sccache"
    return 1
  fi
}

# Main install flow
if [ "$RUNNER_OS" = "macOS" ]; then
  brew install sccache || echo "Warning: brew install failed"
elif [ "$RUNNER_OS" = "Linux" ]; then
  install_from_gh x86_64-unknown-linux-musl "$HOME/.local/bin" sccache
  if [ $? -eq 0 ]; then
    echo "$HOME/.local/bin" >> "$GITHUB_PATH"
  fi
elif [ "$RUNNER_OS" = "Windows" ]; then
  install_from_gh x86_64-pc-windows-msvc "$USERPROFILE/.cargo/bin" sccache.exe
fi

# Always exit 0 to prevent sccache setup from blocking the main build
exit 0
