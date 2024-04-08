# TODO

## Game Design

- [ ] Restrict the trajectory of the ball
- [ ] Base the speed of the ball on the trajectory (e.g., Slowest when going
horizontal, fastest when at the minimum or maximum angle)
    - Dependency #1: [Restrict the trajectory of the ball](#game-design)
- [ ] Reset each paddles position when a point is scored
- [ ] Stop the paddles if they try to go outside the game's window

## Gameplay

- [ ] Reset the game once a player scores a certain number of 10 points
- [ ] Allow the user to pause and unpause the game
- [ ] Create a win condition (e.g., first player to score ten points wins)
- [ ] Correct the movement of the paddles
  - Up and down movements should not negatively affect each other
- [ ] When the ball hits a paddle, its new trajectory should be based off what
part of the paddle it hit
    - Store the desired positions on a paddle (e.g., The center, top third,
    bottom third) can help with this
- ADDITIONAL FEATURE: More balls spawn on the screen as the game progresses
- ADDITIONAL FEATURE: Ball increases velocity as the game progresses
- ADDITIONAL FEATURE: Balls break up into smaller balls after a certain amount of collisions 

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