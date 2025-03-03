# EasyModeration

A simple and efficient moderation plugin for Minecraft Paper servers. This plugin provides essential moderation commands to help server administrators maintain order and control on their servers.

## Features

- Kick players with custom reasons
- Ban players permanently or temporarily
- Mute players (temporary or permanent)
- Warn players
- Freeze/unfreeze players

## Commands

| Command | Usage | Description |
|---------|-------|-------------|
| `/kick` | `/kick <player> [reason]` | Kick a player from the server |
| `/ban` | `/ban <player> [reason]` | Permanently ban a player |
| `/tempban` | `/tempban <player> <duration> [reason]` | Temporarily ban a player |
| `/mute` | `/mute <player> [duration] [reason]` | Mute a player |
| `/unmute` | `/unmute <player>` | Unmute a player |
| `/warn` | `/warn <player> <reason>` | Send a warning to a player |
| `/freeze` | `/freeze <player>` | Freeze a player in place |
| `/unfreeze` | `/unfreeze <player>` | Unfreeze a player |

## Duration Format

For commands that accept duration (tempban, mute):
- `d` - days (e.g., `7d`)
- `h` - hours (e.g., `24h`)
- `m` - minutes (e.g., `30m`)
- `s` - seconds (e.g., `60s`)

Examples:
- `/tempban player1 7d Inappropriate behavior`
- `/mute player2 24h Spamming`

## Permissions

| Permission | Description |
|------------|-------------|
| `easymod.kick` | Allows use of the kick command |
| `easymod.ban` | Allows use of the ban command |
| `easymod.tempban` | Allows use of the tempban command |
| `easymod.mute` | Allows use of the mute command |
| `easymod.unmute` | Allows use of the unmute command |
| `easymod.warn` | Allows use of the warn command |
| `easymod.freeze` | Allows use of the freeze/unfreeze commands |

## Installation

1. Download the latest release from the releases page
2. Place the JAR file in your server's `plugins` folder
3. Restart your server
4. All permissions are set to `op` by default

## Building from Source

1. Clone the repository
2. Run `mvn clean package`
3. The compiled JAR will be in the `target` folder

## Requirements

- Java 17 or higher
- Paper 1.20.4 or higher

## Support

If you encounter any issues or have suggestions, please create an issue on the GitHub repository. 