# Call Taxi Booking Application (Console Based - Java)

Project Overview:

This is a console-based **Call Taxi Booking Application** developed using Java.
The system simulates taxi allocation on a linear route with defined booking rules and fare calculation logic.

The application follows proper **Object-Oriented Programming (OOPS)** principles and is structured using a 3-package architecture.

Route Details:

Points on Route:
A — B — C — D — E — F

* Distance between adjacent points: **15 km**
* Travel time between adjacent points: **1 hour**
* Initial position of all taxis: **Point A**
* Default Taxi Count: **4 (Scalable)**


Fare Calculation Rules:

* Minimum charge for first 5 km: **Rs.100**
* After 5 km: **Rs.10 per km**

Fare Formula:

If distance ≤ 5 km:
Fare = 100

Else:
Fare = 100 + (distance - 5) × 10


Taxi Allocation Rules:

1. A taxi must be **free at pickup time**.
2. Taxi available at the **pickup point** is allocated first.
3. If not available at pickup point:

   * Nearest free taxi is allocated.
4. If multiple taxis are at equal distance:

   * Taxi with **lower total earnings** is allocated.
5. If no taxi is available:

   * Booking is rejected.

How to Run:

1. Compile all Java files.
2. Run `Main.java`
3. Choose options from menu:

   * 1 → Book Taxi
   * 2 → Display Taxi Details
   * 3 → Exit

Technologies Used:

* Java (Core Java)
* OOPS Concepts
* Collections Framework
* Scanner (Console Input)

Output:

<img width="530" height="205" alt="image" src="https://github.com/user-attachments/assets/5ad231ce-89ca-47db-ae69-b534fe9dad55" />

<img width="507" height="280" alt="image" src="https://github.com/user-attachments/assets/12c707c8-3750-4556-a9fa-ba600d8507d7" />

<img width="647" height="277" alt="image" src="https://github.com/user-attachments/assets/c1487a0f-73ae-411a-b931-37d7b4216053" />

<img width="543" height="343" alt="image" src="https://github.com/user-attachments/assets/049fb363-f7cc-4e28-9abd-94977909db37" />
