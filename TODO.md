# TODO

## Game Design

- [ ] Restrict the trajectory of the ball
- [ ] Base the speed of the ball on the trajectory (e.g., Slowest when going
horizontal, fastest when at the minimum or maximum angle)
  - Dependency #1: [Restrict the trajectory of the ball](#game-design)

## Gameplay

- [ ] Allow the user to pause the game
- [ ] Create a win condition (e.g., first player to score ten points wins)
- [ ] Correct the movement of the paddles
  - Up and down movements should not negatively affect each other

## Graphics

## Project Management

## Sound

- [ ] Gameplay background music
- [ ] Ball bounce on paddle sound effect
- [ ] Point scored sound effect
- [ ] Game start sound effect
- [ ] Game win sound effect
  - Dependency #1: [Create a win condition](#gameplay)

## User Interface

- [ ] Create a pause menu
    - Dependency #1: [Allow the user to pause the game](#gameplay)
- [ ] Create a main menu
- [ ] Create a game end menu
  - Dependency #1: [Create a win condition](#gameplay)