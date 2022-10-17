# Goals

## Minimum Viable Product

### User Auth:
- (external service) Uses AWS to handle email and password, so we don't have to.
- Connect account to Discord account using OAuth2.

### User-information:
- (stored in our Database, referencing an external service) Store the information by Discord user.
- Provide a form to input the following game information:
  - Friend code and (maybe) name from Nintendo Switch profile. Used by users to connect to each other if shared.
  - SplashTag Name (in-game name), and potentially tag (the 4-digit number). Used for identifying the Splatoon 3 player.
  - Any user configurations/preferences, such as automatically sharing friend code, or broadcasting when they're ready to play.

### Finding a game:
- (Its own page, making use of Java Discord API)
  - Status broadcasting (more simple):
    - If the user chooses, let the bot broadcast that the user is in a room looking for a game.
    - Stop broadcasting when the group is full.

## Stretch Goals

### Media sharing:
- Allow users to share and browse:
  - Video captures
    - accessed through YouTube and Twitter links
    - potentially features embedded information
  - Fan-art
    - accessed through Twitter (and maybe an image-hosting site?)
    - potentially features embedded information
  - Memes
    - accessed through Twitter (and maybe an image-hosting site?)
    - potentially features embedded information
- Post new media to a Discord feed