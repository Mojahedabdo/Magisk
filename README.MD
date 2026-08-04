# Magisk-but-Expressive

## <img src="./asset/icon.gif" width="44px" /> About

**Magisk-but-Expressive** is an independent and unofficial fork of Magisk featuring a completely rewritten Android application interface.

The original Magisk app interface has been replaced with a new implementation built using **Jetpack Compose**, with a modern design inspired by **Material 3 Expressive**.

The project remains based on the upstream Magisk source code and preserves the main Magisk functionality, including root management, modules, Zygisk and boot image patching.

Release builds are packaged with precompiled native binaries independently extracted from publicly distributed **Magisk Alpha** builds.

The source code used to develop the Magisk Alpha binaries is not publicly available.

### Project links

- **Magisk upstream:** https://github.com/topjohnwu/Magisk
- **Magisk Alpha channel:** https://t.me/magiskalpha
- **Magisk-but-Expressive repository:** https://github.com/Anto426/Magisk-but-expressive
- **Magisk-but-Expressive Telegram channel:** https://t.me/magiskBe

```sh
magisk@android:~$ whoami
Magisk-but-Expressive

magisk@android:~$ echo "platform"
Android 6.0+ (Marshmallow and above)

magisk@android:~$ echo "interface"
Jetpack Compose + Material 3 Expressive

magisk@android:~$ echo "repo"
https://github.com/Anto426/Magisk-but-expressive

magisk@android:~$ echo "telegram"
https://t.me/magiskBe
```

Magisk is an open-source Android customization suite providing systemless root, module support, boot image tooling and process-level runtime extensions.

Magisk-but-Expressive replaces the original Android application interface while keeping the underlying Magisk functionality available through a new Compose-based frontend.

> [!IMPORTANT]
> Magisk, Magisk Alpha and Magisk-but-Expressive are separate projects.
>
> Magisk-but-Expressive is not maintained, endorsed or officially supported by the developers of Magisk or Magisk Alpha.

<p align="center">
  <img src="./asset/divider.gif" width="440" height="40" />
</p>

## <img src="./asset/icon2.gif" width="48px" /> Highlights

- Completely rewritten Android application interface.
- Built using Jetpack Compose.
- Modern design inspired by Material 3 Expressive.
- Dynamic color support.
- Light, dark and AMOLED appearance modes.
- Custom color theme support.
- Systemless root and Android customization.
- Superuser permission management.
- Magisk module installation and management.
- Zygisk support for process-level runtime extensions.
- Boot image patching and installation tooling.
- Compatibility with the Magisk module ecosystem.
- Support for Android 6.0 and newer.
- Open-source development based on the upstream Magisk project.

<p align="center">
  <img src="./asset/divider.gif" width="440" height="40" />
</p>

## Downloads

Download Magisk-but-Expressive APKs and release artifacts only from the official GitHub repository:

- [GitHub Releases](https://github.com/Anto426/Magisk-but-expressive/releases)

Release announcements, project updates and important information are also published on the official Telegram channel:

- [Magisk-but-Expressive Telegram Channel](https://t.me/magiskBe)

For installation instructions, follow the official Magisk installation guide:

- [Magisk Installation Guide](https://topjohnwu.github.io/Magisk/install.html)

> [!WARNING]
> Rooting and modifying boot images may cause bootloops, instability or data loss.
>
> Before installing, back up your original `boot`, `init_boot` or other relevant device images and make sure you have a working recovery method.

<p align="center">
  <img src="./asset/divider.gif" width="440" height="40" />
</p>

## Binary Source and Versioning

Release builds of Magisk-but-Expressive include precompiled native binaries independently extracted from publicly distributed Magisk Alpha builds.

The source code used to develop these Magisk Alpha binaries is not publicly available.

Magisk-but-Expressive does not claim ownership of the Magisk Alpha binaries and is not affiliated with the Magisk Alpha developers.

The binaries were not specifically provided or officially distributed by the Magisk Alpha developers for use in this project.

The Magisk-but-Expressive version follows the corresponding Magisk Alpha binary build, for example:

```text
e8a58776-alpha
```

This identifier represents the Magisk Alpha build used by the application.

It does not describe the development maturity of the Magisk-but-Expressive interface and does not mean that the project itself is in its first alpha release.

The application, stub, daemon and native components must remain compatible with one another. Mixing components from different versions or changing the version identifier independently may cause installation failures, incompatibilities or unexpected behaviour.

<p align="center">
  <img src="./asset/divider.gif" width="440" height="40" />
</p>

## <img src="./asset/icon2.gif" width="48px" /> Screenshots

<p align="center">
  <img src="./asset/images/Screenshot_1.png" alt="Magisk-but-Expressive screen 1" width="240" />
  <img src="./asset/images/Screenshot_2.png" alt="Magisk-but-Expressive screen 2" width="240" />
  <img src="./asset/images/Screenshot_3.png" alt="Magisk-but-Expressive screen 3" width="240" />
  <img src="./asset/images/Screenshot_4.png" alt="Magisk-but-Expressive screen 4" width="240" />
  <img src="./asset/images/Screenshot_5.png" alt="Magisk-but-Expressive screen 5" width="240" />
  <img src="./asset/images/Screenshot_6.png" alt="Magisk-but-Expressive screen 6" width="240" />
  <img src="./asset/images/Screenshot_7.png" alt="Magisk-but-Expressive screen 7" width="240" />
  <img src="./asset/images/Screenshot_8.png" alt="Magisk-but-Expressive screen 8" width="240" />
  <img src="./asset/images/Screenshot_9.png" alt="Magisk-but-Expressive screen 9" width="240" />
</p>

<p align="center">
  <img src="./asset/divider.gif" width="440" height="40" />
</p>

## Useful Links

- [Magisk Installation Instructions](https://topjohnwu.github.io/Magisk/install.html)
- [Magisk Building and Development Documentation](https://topjohnwu.github.io/Magisk/build.html)
- [Magisk Documentation](https://topjohnwu.github.io/Magisk/)
- [Zygisk Module Sample](https://github.com/topjohnwu/zygisk-module-sample)
- [Magisk Alpha Telegram Channel](https://t.me/magiskalpha)
- [Magisk-but-Expressive Telegram Channel](https://t.me/magiskBe)

<p align="center">
  <img src="./asset/divider.gif" width="440" height="40" />
</p>

## <img src="./asset/icon3.gif" width="48px" /> Building and Development

### Setup Environment

Supported platforms:

- Linux x64
- macOS x64
- macOS arm64
- Windows x64

On Windows, enable Developer Mode because symbolic link support is required.

### Install Python

Install Python 3.8 or newer.

- On Linux and macOS, install `python3` using your preferred package manager.
- On Windows, install Python from the official Python website.
- On Windows, enable **Add Python to PATH** during installation.
- Optionally install `colorama`:

```sh
pip install colorama
```

### Install Git

- On Linux and macOS, install `git` using your preferred package manager.
- On Windows, install Git from the official Git website.
- On Windows, enable symbolic link support during installation.

### Install Android Studio

Install Android Studio and complete the initial setup wizard.

Set `ANDROID_HOME` to your Android SDK directory. The SDK path is available in the Android Studio settings.

### Configure the JDK

The recommended configuration is to set `ANDROID_STUDIO` to the Android Studio installation directory.

The build scripts will automatically detect and use the JDK bundled with Android Studio.

Alternatively, configure JDK 21 manually.

### Clone the Repository

```sh
git clone --recurse-submodules https://github.com/Anto426/Magisk-but-expressive.git
cd Magisk-but-expressive
```

### Install the NDK

On Linux or macOS:

```sh
./build.py ndk
```

On Windows:

```powershell
python build.py ndk
```

### Building

Build all supported components and generate the final APK:

```sh
./build.py all
```

On Windows:

```powershell
python build.py all
```

Display the available build actions:

```sh
./build.py
```

Display help for a specific action:

```sh
./build.py binary -h
```

Build behaviour can be configured using:

```text
config.prop
```

A sample configuration is available in:

```text
config.prop.sample
```

### IDE Support

Kotlin, Java, C and C++ sources are supported by Android Studio.

Open the repository directly as an Android Studio project.

Before modifying native code, run:

```sh
./build.py binary
```

Some native files and generated sources are created during the build process.

<p align="center">
  <img src="./asset/divider.gif" width="440" height="40" />
</p>

## Developing Rust

Install `rustup`, the official Rust toolchain manager.

The Magisk NDK package, also known as ONDK, includes the Rust toolchain required for normal Magisk builds.

To expose the ONDK Rust toolchain through `rustup`:

```sh
rustup toolchain link magisk "$ANDROID_HOME/ndk/magisk/toolchains/rust"
rustup default magisk
```

For Visual Studio Code, install the `rust-analyzer` extension.

For RustRover or IntelliJ with the Rust plugin, install the nightly toolchain for IDE compatibility:

```sh
rustup toolchain install nightly
rustup +nightly component add rust-src clippy
```

Create a wrapper Cargo binary directory:

```sh
./build.py rustup ~/.cargo/wrapper
```

Then set the Rust toolchain location in the IDE to:

```text
~/.cargo/wrapper
```

<p align="center">
  <img src="./asset/divider.gif" width="440" height="40" />
</p>

## Signing and Distribution

In release builds, the certificate used to sign the APK is used by the Magisk root daemon as a trusted identity.

An application signed with a different certificate may be rejected or force-uninstalled to prevent untrusted applications from controlling the root daemon.

For development, use a compatible debug environment and reinstall the appropriate build when changing signing identities.

To distribute builds signed with your own key, configure the signing values in:

```text
config.prop
```

For information about generating and managing signing keys, see the Android application signing documentation.

Do not redistribute modified builds under the Magisk-but-Expressive name without clearly identifying the modifications and the different signing identity.

<p align="center">
  <img src="./asset/divider.gif" width="440" height="40" />
</p>

## Bug Reports

When reporting an issue, provide enough information to reproduce and investigate the problem.

Include:

- Device manufacturer and model.
- Android version.
- ROM name and version.
- Magisk-but-Expressive version.
- Installation method.
- Clear reproduction steps.
- Relevant screenshots or screen recordings.
- Complete logs.

For installation problems, provide:

- The original boot image when appropriate.
- Installation logs.
- Information about the partition that was patched.

For Magisk or daemon problems, provide:

- Boot `logcat`.
- `dmesg`.
- Magisk logs.

For application crashes, capture `logcat` while reproducing the crash.

Reports containing only messages such as “it does not work” may not contain enough information to be investigated.

<p align="center">
  <img src="./asset/divider.gif" width="440" height="40" />
</p>

## Translation Contributions

Default string resources for the main application and stub APK are located in:

```text
app/core/src/main/res/values/strings.xml
app/stub-res/src/main/res/values/strings.xml
```

Add translated resources using the appropriate Android resource directory:

```text
[module]/src/main/res/values-[language]/strings.xml
```

Examples:

```text
values-it/strings.xml
values-fr/strings.xml
values-de/strings.xml
```

Keep placeholders, formatting tags and resource names unchanged unless the original resource has also been modified.

<p align="center">
  <img src="./asset/divider.gif" width="440" height="40" />
</p>

## Credits

- [topjohnwu](https://github.com/topjohnwu) — creator and maintainer of the original Magisk project.
- [Magisk Alpha](https://t.me/magiskalpha) — source of the precompiled native binaries integrated into release builds.
- [Anto426](https://github.com/Anto426) — Magisk-but-Expressive maintainer and author of the rewritten Jetpack Compose interface.
- All upstream Magisk contributors and module developers.

The mention of Magisk Alpha as the binary source does not imply endorsement, partnership, affiliation or official support.

<p align="center">
  <img src="./asset/divider.gif" width="440" height="40" />
</p>

## <img src="./asset/icon4.gif" width="48px" /> License

```text
Magisk, including all git submodules, is free software:
you can redistribute it and/or modify it under the terms of the
GNU General Public License as published by the Free Software Foundation,
either version 3 of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program. If not, see <http://www.gnu.org/licenses/>.
```
