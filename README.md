Assessment2MobileAppDev — Fashion Dashboard

Overview:

Android app using MVVM that fetches fashion entities from a REST API and shows them in a RecyclerView, Tap an item to open a details screen with full info

Requirements:

Android Studio current

Android SDK 24+

Kotlin and Gradle

Manifest permissions

Quick setup

1.Open the project in Android Studio and let Gradle sync

2.Set the API base URL in di/NetworkModule-kt

3.Run on device or emulator

4.Default keypass is fashion but your extension can be different

How it works

1.ApiService

   GET /dashboard/{keypass} → EntitiesResponse
   
2.Repository

   Unwraps entities to List<Entity>
   
3.ViewModel

   Exposes StateFlow<List<Entity>> and optional uiState
   
4.Fragment

   Collects flows and updates RecyclerView and on item tap navigate to details passing Entity as Parcelable

-----------------------------API contract----------------------

Endpoint
-	GET /dashboard/{keypass}
Response shape
{"entities": [
{ "itemName": "Little Black Dress",
"designer": "Coco Chanel",
"yearIntroduced": 1926,
"category":
"Dresses",
"material": "Various",
"description": "..." }],
     "entityTotal": 7
   }

Models
Entity Parcelable
-	itemName String?
-	designer String?
-	yearIntroduced Int?
-	category String?
-	material String?
-	description String?
EntitiesResponse
-	entities List<Entity>

-------Key files-------

Data model

   Entity-kt
   EntitiesResponse-kt
Data remote

   ApiService-kt
Data repo

   RestfulApiRepository-kt
di (Dependency Injection)

   NetworkModule-kt
ui dashboard

   DashboardFragment-kt
   DashboardAdapter-kt
ui

   RestfulApiViewModel-kt

Usage

   App loads fashion by default
   Change dataset with viewModel-refresh("<your-keypass>") or update the default in RestfulApiViewModel
