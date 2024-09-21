# Parking Lot Design

### Statement
- The parking lot should have multiple floors where customers can park their cars.
- Customers can collect a parking ticket from the entry points and can pay the parking fee at the exit points to the parking attendant or automated exit panel
- Customers can pay via both cash and credit cards.
- The system should not allow more vehicles than the maximum capacity of the parking lot. If the parking is full, the system should be able to show a message at the entrance panel and on the parking display board on the ground floor.
- Each parking floor will have many parking spots. The system should support multiple types of parking spots such as Compact, Large, Disabled, Motorcycle, etc.
- The system should support parking for different types of vehicles like car, truck, van, motorcycle, etc.
- Each parking floor should have a display board showing any free parking spot for each spot type.
- The system should support a per-hour parking fee model. For example, customers have to pay some amount based on the Vehicle type.
- Admins should be able to add parking floors and parking spot.

### Pattern Covered
- Singleton
- Builder
- Strategy
- Factory



### Additional Things can be done
- Currently, multiple entries are not provided. 
- With multiple entries and nearest servicing, its important how to implement nearest available parking functionality. 
- With only multiple entries, parking spots can be taken as a list.
- with single entry and nearest servicing, priorityQueue has been taken for the time. 
- In some cases, people have used bfs and heaps as well to serve.