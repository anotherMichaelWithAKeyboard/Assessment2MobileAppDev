Assessment2MobileAppDev — Fashion Dashboard

Overview
-	Android app using MVVM that fetches fashion entities from a REST API and shows them in a RecyclerView
-	Tap an item to open a details screen with full info

Requirements
-	Android Studio current
-	Android SDK 24+
-	Kotlin and Gradle
-	Manifest permissions
-		INTERNET
-		ACCESS_NETWORK_STATE

Quick setup
-	Open the project in Android Studio and let Gradle sync
-	Set the API base URL in di/NetworkModule-kt
-		private const val BASE_URL = "https://<your-api-host>/"
-	Run on device or emulator
-	Default keypass is fashion

How it works
-	ApiService
-		GET /dashboard/{keypass} → EntitiesResponse
-	Repository
-		unwraps entities to List<Entity>
-	ViewModel
-		exposes StateFlow<List<Entity>> and optional uiState
-	Fragment
-		collects flows and updates RecyclerView
-		on item tap navigate to details passing Entity as Parcelable

API contract
-	Endpoint
-		GET /dashboard/{keypass}
-	Response shape
-		{
-		  "entities": [
-		    { "itemName": "Little Black Dress", "designer": "Coco Chanel", "yearIntroduced": 1926, "category": "Dresses", "material": "Various", "description": "..." }
-		  ],
-		  "entityTotal": 7
-		}

Models
-	Entity Parcelable
-		itemName String?
-		designer String?
-		yearIntroduced Int?
-		category String?
-		material String?
-		description String?
-	EntitiesResponse
-		entities List<Entity>

Key files
-	data model
-		Entity-kt
-		EntitiesResponse-kt
-	data remote
-		ApiService-kt
-	data repo
-		RestfulApiRepository-kt
-	di
-		NetworkModule-kt
-	ui dashboard
-		DashboardFragment-kt
-		DashboardAdapter-kt
-	ui
		RestfulApiViewModel-kt

Usage
-	App loads fashion by default
-	Change dataset with viewModel-refresh("<your-keypass>") or update the default in RestfulApiViewModel
