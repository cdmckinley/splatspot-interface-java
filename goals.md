# Goals

## Minimum Viable Product

### User Auth:
- (external service) Uses Discord to handle email and password, so we don't have to.
- Login through Discord via OAuth2.

### Player-information:
- (stored in our Databse, referencing an external service) Store the information by Discord user.
- Provide a form to input the following game information:
  - Friend code and (maybe) name from Nintendo Switch profile.
  - SplashTag Name (in-game name), and potentially tag (the 4-digit number), for identifying the player.
  - Any user configurations/preferences.

### Finding a game:
- (It's own page, making use of Java Discord API)
- One or more of the following:
  - Matchmaking (complicated):
    - Let the user que up for matchmaking in a team (default of 4).
    - Either:
      - Match teams of 4 players, and a game of 2 teams.
      - Match a group of 8 players, and randomly assign teams.
  - Status broadcasting (more simple):
    - If the user chooses, let the bot broadcast that the user is in a room looking for a game.
    - Stop broadcasting when the group is full.

## Stretch Goals
### Finding a game:
- Implement both matchmaking and status broadcasting

### Media sharing:
- Allow users to share and browse:
  - Replay codes
    - stored in code form
    - viewable by entering the code in Splatoon 3
  - Video captures
    - accessed through YouTube and Twitter links
    - potentially features embedded information
  - Fan-art
    - accessed through Twitter (and maybe an image-hosting site?)
    - potentially features embedded information
  - Memes
    - accessed through Twitter (and maybe an image-hosting site?)
    - potentially features embedded information