# CS3398-Fall2018-AndrroidApp

# Status of Project
We connected frontend and backend parts. The app now can login and signup. Upon signing up, new users will recieve a confirmation email. On the frontend we also added a user, menu, information and favorites page. Next steps for our team members include:
* Andrew Hyatt: Assisting Danh with integrating orders and payments to our application, as well as continuing customer reward functionality. Will also attempt to improve the email that is sent to users that register for an account to include more information and not be sent to spam.
* Danh Pham: Make the database for orders and payments, and connects those databases with Android App
* Le Cuong: Design the Homepage and Menu, link these bottons to the logging page
* Zak King: Polish GUI and work with backend to implement all features layed out in the front end pages. 
* Alexander Muyshondt: Polish up user profile page and help connect existing frontend with backend for sprint 3.

# How to run the app.
 - Download the file <a href="https://github.com/CS3398-Mimas-Mimes/CS3398-Fall2018-AndrroidApp/tree/master/apk">Mimas_11_07.apk</a> to your android phones.
 - Install and run this app in your android phones
 - Current features of app: Login, SignUp (You will receive an confirmation email if you enter a valid email)

# Individual (Artifact References and Proof of Work)
Andrew Hyatt
- I worked on creating a table for storing menu items in the database. 
- On my aHyatt-menu-db branch, I created <a href="https://github.com/CS3398-Mimas-Mimes/CS3398-Fall2018-AndrroidApp/blob/aHyatt-menu-db/app/src/main/java/com/example/danhpham/group2/Menu.java">Menu.java</a> to retrieve these menu items from the database. 
- On my aHyatt-email branch, I updated <a href="https://github.com/CS3398-Mimas-Mimes/CS3398-Fall2018-AndrroidApp/blob/aHyatt-email/app/src/main/java/com/example/danhpham/group2/SignUp.java">SignUp.java</a> to send an email when a new user signs up for our app (this branch has been merged to master). 
- On my aHyatt-customer-rewards branch, I've added a <a href="https://github.com/CS3398-Mimas-Mimes/CS3398-Fall2018-AndrroidApp/tree/aHyatt-customer-rewards/app/src/main/java/com/example/danhpham/group2/reward">reward package</a> which includes CurrentRewards.java (a file which tracks the user's current rewards), Reward.java (a parent class for objects of type Reward), DiscountReward.java (a sub-class that inherits from Reward class, which introduces basic discount functionality), and IRewardable.java (which is an interface for applying a customer's reward). 

Danh Pham
- I worked on database and contribute to write the login and signup php file to receive the login and signup information from the android app. Search those information in database (with login) and Fill in those signup information.
- Contribute to <a href="https://github.com/CS3398-Mimas-Mimes/CS3398-Fall2018-AndrroidApp/blob/master/app/src/main/java/com/example/danhpham/group2/Login.java">Login.java</a> and <a href="https://github.com/CS3398-Mimas-Mimes/CS3398-Fall2018-AndrroidApp/blob/master/app/src/main/java/com/example/danhpham/group2/SignUp.java">SignUp.java</a> (to send information to server)

Le Cuong 
  - I woked on the Homepage and add some items to Menu, also connect them to logging page  <a href="https://github.com/CS3398-Mimas-Mimes/CS3398-Fall2018-AndrroidApp/blob/zacharyking2016/app/src/main/java/com/example/danhpham/group2/HomePageActivity.java">Homepage.java</a> and  <a href="https://github.com/CS3398-Mimas-Mimes/CS3398-Fall2018-AndrroidApp/blob/zacharyking2016/app/src/main/java/com/example/danhpham/group2/Menu.java">Menu.java</a>
  


Zak King - Created the <a href="https://github.com/CS3398-Mimas-Mimes/CS3398-Fall2018-AndrroidApp/blob/zacharyking2016/app/src/main/res/layout/activity_info.xml">Information page</a> and the <a href="https://github.com/CS3398-Mimas-Mimes/CS3398-Fall2018-AndrroidApp/blob/zacharyking2016/app/src/main/res/layout/activity__user_orders.xml">Favorites page</a> as well as creating all the functions to make the <a href="https://github.com/CS3398-Mimas-Mimes/CS3398-Fall2018-AndrroidApp/tree/zacharyking2016/app/src/main/java/com/example/danhpham/group2">Buttons</a> to work on all of the front end pages


Alexander Muyshondt
- Created the user profile page, including user avatar and user-specific attributes such as username, password, credit card information and Favorites button. (https://github.com/CS3398-Mimas-Mimes/CS3398-Fall2018-AndrroidApp/blob/master/app/src/main/res/layout/users_profile.xml)
- For Sprint 3, functionality will be added for the user to change their credit card information and look at their favorite meals using the button in their profile.
