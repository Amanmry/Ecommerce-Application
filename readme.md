# Ecommerce Backend

## Product Entity

![alt text](markdown-images/image.png)

---

## Cart Entity

![alt text](markdown-images/image-1.png)

Notes: 

What is the Active Record Pattern?

The Active Record Pattern is a design pattern where the object is responsible for both the data and the behavior associated with that data.

our application is following a hybrid approach, where the Cart entity still encapsulates some business logic (e.g., adding/removing items), but the persistence logic is handled by the repository and service layers, which aligns with the Data Mapper pattern.

Domain Logic:

The business logic for adding/removing items and updating the total amount is still within the Cart class, which is fine and could still be part of a hybrid approach.

---