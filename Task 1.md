# **TASK - 1**

## Exploratory Testing Session of the Monefy iOS App

Testing Objective - Monefy application for money management which allows users to track their expenses and income.


### **Install application**

| Step	| Expected result |
|   -------------   |   --------------- | 
| Install Monefy app from App Store |	Application is installed successfully. |
| Open application	| Application is opened 


## **Testing on different devices**

List of Devices on which, this app was tested - 

* iPhone XR (iOS Version - 15.1 )
* iPhone 12 Pro Max (iOS Version - 15.6.1)

## **Exploratory Testing Test Charter**

#### #Criteria - High & Medium priority cases are must to be verified to make sure application is working fine.

**High Priority Test Cases** - These Test Scenarios are set to High priority as they have high value to Business (Security features, Enabling Pro user, Managing User Data, Basic Features) & End-user Requirements.

1. Verify the app is installed and launched correctly on different devices with different OS versions having different screen resolution and sizes.

 2. Verify the user is able to make the payment successfully and upgraded to Pro version of the app.

 3. Verify the user can still continue to use the basic features of the app like adding an income and expense even if it's not a Pro/Upgraded user.
 4. Verify that the user can seamlessly use the Pro features (Adding new Expense & Income categories) of the app on upgrading to Pro version
 5. Verify the user is successfully able to add new income and the added income is displayed correctly in the Pie Chart.
 6. Verify the user is successfully able to add a new expense and the correct balance (even if it goes negative) is displayed correctly in the Pie Chart with appropriate color.
 7. Verify the pro user can use the app in Dark theme and the look & feel of the app remains the same even if the colors have been inverted.
 8. Verify the user data (balance, accounts) is not lost on switching the themes between Dark & Light.
 9. Verify the user can switch between the themes (Dark & Light) at any given point and the app does not crash or behaves inappropriately after switching.
 10. Verify the pro user can add a schedule succesfully
 11. Verify the user can add multiple accounts having different types and the user can tranfer amount between these accounts.
 12. Verify the pro user can use the app in different currencies.
 13. Verify that the mathematic calculations take place correctly even on changing the Currencies.
 14. Verify the app is securely protected by passcode for the pro user.
 15. Verify the user can search for any added record on the basis of category and added note.
 16. Verify the user can view the historical records on selecting a past date.
 17. Verify the user data is not lost and the app does not crash if the Wi-fi or cellular network is turned while doing an action.

**Medium Priority Test Cases** - These test scenarios are prioritized to Medium as they have medium impact on the functionality (Calendar intervals, Accumulation and display of data) and the lesser-used user features (Syncing to Cloud, Dropbox, Monthly budget, carry over).

 1. Verify the user can add new income records even in Offline/Airplane mode.
 
 2. Verify the user can add new expense records in Offline/Airplane mode.
 3. Verify that all the added records of current day are displayed on swiping up on the balance span.
 4. Verify the user can modify the existing expense and income records and those modifications are reflected correctly in the pie-chart. 
 5. Verify the user can view the added records on the basis of Day, Week, Month, Year, Interval.
 6. Verify the monthly budget is displayed on enabling it.
 7. Verify the Carry over amount is displayed on enabling it.
 8. Verify the sync to Google Drive is working fine.
 9. Vwerify the sync to Dropbox is working fine.
 10. Verify Language selection,Currency selection, First day of Week/Month selection and export to file options under settings.
 11. Verify the exported file is opened correctly and correct data is displayed in it.

**Low Priority Test Cases** - These test cases have been set to Low priority as they have less dependency on functional app behaviour (Review App), more dependency on UI based elements (color coding, category icons, side panel UX) and edge test cases.

 1. Verify the expense records are displayed in red color, expense in green color and overall balance is displayed in red if expenses are greater than income sum.
 
 2. Verify the user can create a new income record having a large no. of characters in the note.
 3. Verify the user can change the view of the added records by clicking on the icon besides the balance span.
 4. Verify the user can open and close the side panels without any glitch.
 5. Verify the app can be succesfully reviewed on App store by using the Review App functionality.
 6. Verify Selection of AllAccounts/Cash/PaymentCard shall populate correct results on Home Screen.


### Risks to be considered for this Application

 * Business Risks - Pro user Business model and its features, Incorrect or incomplete requirements, Changes in the requirements during development, Competing with the features and business model of similar apps, Expanding Customer Base.

 * Software Development Risks - Using latest technologies to upgrade the app, Resolving user complaints, Integration with cloud based technologies.
