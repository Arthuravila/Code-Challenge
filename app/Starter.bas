B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Service
Version=8.3
@EndOfDesignText@
#Region  Service Attributes 
	#StartAtBoot: False
	#ExcludeFromLibrary: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	
	Public apiKey As String = "c5850ed73901b8d268d0898a8a9d8bff"
	Public urlPrincipal As String = "https://api.themoviedb.org/3/movie/"
	Public urlGenre As String = "https://api.themoviedb.org/3/genre/movie/" 
	Public urlPoster As String = "https://image.tmdb.org/t/p/w185"
	Public urlSearch As String = "https://api.themoviedb.org/3/search/movie"
	Public language As String = "en-US"
	
	Public su As StringUtils

End Sub

Sub Service_Create
	'This is the program entry point.
	'This is a good place to load resources that are not specific to a single activity.

End Sub

Sub Service_Start (StartingIntent As Intent)
	

End Sub

Sub Service_TaskRemoved
	'This event will be raised when the user removes the app from the recent apps list.
End Sub

'Return true to allow the OS default exceptions handler to handle the uncaught exception.
Sub Application_Error (Error As Exception, StackTrace As String) As Boolean
	Return True
End Sub

Sub Service_Destroy

End Sub
