# shopingCoding
The simple code demonstates the solution for the following problem statement

## High level description of the code 
1. The code takes product list and offer list as inputs
2. Customer's shoppingList is prepared as per the purchases made
3. The list is scanned again offers and discounts are calculated against the offer rules and items against which offer is running
4. The final discounted price is displayed


## Configuration
1. Gi clone project
2. Added external dependency library Junit4 (if required)


## Unit tests
Unit test are listed in UnitTest package

## JavaDocs
please refer /Docs folder in the source code

## Execution
1. Select from predefined use case or define a new use case. Assign the use case(String array) to shoppingList variable

```java

    private static String[] shopingList1 = {"atv", "atv", "atv", "vga"};
   
    private static String[] shopingList2 = {"atv", "ipd", "ipd", "atv", "ipd", "ipd", "ipd"};
   
    private static String[] shopingList3 = {"mbp", "vga", "ipd"};

    private static final String[] shoppingList = shopingList3;  //assign use case to test
```

2. Run ComputerStoreMain.java as it contains main()


## Problem statement
DiUS is starting a computer store. You have been engaged to build the checkout system. We will start with the following products in our catalogue


| SKU     | Name        | Price    |
| --------|:-----------:| --------:|
| ipd     | Super iPad  | $549.99  |
| mbp     | MacBook Pro | $1399.99 |
| atv     | Apple TV    | $109.50  |
| vga     | VGA adapter | $30.00   |

As we're launching our new computer store, we would like to have a few opening day specials.

- we're going to have a 3 for 2 deal on Apple TVs. For example, if you buy 3 Apple TVs, you will pay the price of 2 only
- the brand new Super iPad will have a bulk discounted applied, where the price will drop to $499.99 each, if someone buys more than 4
- we will bundle in a free VGA adapter free of charge with every MacBook Pro sold

As our Sales manager is quite indecisive, we want the pricing rules to be as flexible as possible as they can change in the future with little notice.

Our checkout system can scan items in any order.

The interface to our checkout looks like this (shown in java):

```java
  Checkout co = new Checkout(pricingRules);
  co.scan(item1);
  co.scan(item2);
  co.total();
```

Your task is to implement a checkout system that fulfils the requirements described above.

Example scenarios
-----------------

SKUs Scanned: atv, atv, atv, vga
Total expected: $249.00

SKUs Scanned: atv, ipd, ipd, atv, ipd, ipd, ipd
Total expected: $2718.95

SKUs Scanned: mbp, vga, ipd
Total expected: $1949.98
