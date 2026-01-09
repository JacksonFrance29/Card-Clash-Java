# Card Clash

A Java-based, console-driven card game simulation that models a simplified “War”-style game between a player and a computer opponent.  
This project emphasizes object-oriented design, class responsibilities, and game-state management.

## Overview
Card Clash simulates a full card game using a standard deck. Cards are shuffled, dealt evenly between two players, and played round-by-round until one player wins or a maximum round limit is reached to prevent infinite games.

This project was built to demonstrate core Java concepts, including classes, encapsulation, control flow, collections, and debugging.

## Project Structure
```text
src/
├── Card.java      // Represents an individual playing card
├── Deck.java      // Creates, stores, and shuffles the deck
├── Player.java    // Manages a player's hand and actions
└── CardClash.java // Main game loop and simulation logic
```

## How It Works
1. A standard 52-card deck is created and shuffled.
2. Cards are dealt evenly between the player and the computer.
3. Each round:
   - Both players draw a card
   - The higher-value card wins the round
   - The winner collects both cards
   - If both players draw cards of equal value, a "war" occurs:
        - Each player places additional cards
        - The final card is compared
        - The player with the higher card collects all cards from that round
4. The game continues until:
   - One player runs out of cards, or
   - A maximum round limit is reached to prevent infinite play
5. The winner is announced based on who has the most cards at the end of the simulation.

## Technologies Used
- Java
- Object-Oriented Programming (OOP)
- Java Collections (`ArrayList`)
- Control flow & debugging
