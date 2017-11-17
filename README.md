# Sims Resource Tests

List of Tests:
* [Log in](#login)
* [Basket Set Up / Before Test](#setup)
* [Add Item Set to Basket](#addItemSet)
* [Add Single Item to Basket](#addSingleItem)


#### <a name="login"></a>Log In

* ##### Objective:
    Fascinating stuff. As well as clicking a button and sending some keys (which you'll note are absent from my gitHub because they contain my actual information). I confirm I'm logged in. I have a $3 monthly subscription for this VIP account which is visible at login. Unfortunately,the elements I used to confirm my aforementioned very important VIP status, were always present and clickable even though they were not visible. As such, I simply asserted that the element was VISIBLE upon login. Like I said, thrilling stuff.

#### <a name="setup"></a>Basket Set Up / Before Test

* ##### Technical Approach:
    Creating instances of a chrome driver because it is objectively The-Best-Browser™. Also running that exciting login test and making sure the basket is empty before we start getting creative. This involves checking if the basket is empty, and if not, emptying it and accepting the browser-alert that confirmed the task was done.

#### <a name="addItemSet"></a>Add Item Set to Basket

* ##### Objective:
    On thesimsresource, a download page will contain either a single item, or a set of items. This test deals with the sets specifically.
* ##### Technical Approach:
    It isn't the cleanest way of getting things done, but I reeeally wanted to play with hashmaps. The test involves going to a tab on the page that lists each item in the set and creating a list of their unique IDs (I use regex to drag it out of the href). It then clicks "Add to Basket" and creates a hashmap of items in the basket. Finally a loop iterates over the list of IDs and asserts that each one exists as a key in the hashmap.

#### <a name="addSingleItem"></a>Add Single Item to Basket

* ##### Objective:
    This test deals with adding a specific single item to the basket and asserting it's there.
* ##### Technical Approach:
    We specify the item's unique ID in a variable at the start. It feeds into the web element, so the jquery searches for the static "div#basketitem_" + the variable "itemID". The test then opens the basket and asserts that the same ID is present.

