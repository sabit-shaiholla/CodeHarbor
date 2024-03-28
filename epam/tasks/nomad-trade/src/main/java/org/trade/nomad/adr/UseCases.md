```plantuml

@startuml

left to right direction

actor User
actor Seller
actor System

rectangle "User Registration" {
  User -- (Provide Registration Information)
  System -- (Validate Information)
  System -- (Create User Account)
}

rectangle "Product Browsing" {
  User -- (Enter Search Criteria)
  System -- (Retrieve Products)
  User -- (View Product Details)
}

rectangle "Order Management" {
  Seller -- (View Incoming Orders)
  Seller -- (Update Order Status)
  System -- (Update Order Information)
}

rectangle "Feedback and Reviews" {
  User -- (Select Product/Seller)
  User -- (Provide Rating and Comments)
  System -- (Record Feedback)
  System -- (Update Ratings)
}

@enduml

```