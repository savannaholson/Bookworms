#User Documentation

Your guide to using our service

---

##Using our web service

####Making the request

Our service uses two url parameters. The url path from the place where the service is running is: webService/$authorFirstName/$authorLastName

The things in the url with a $ in front of them should be replaced with the first and last name of the author who's books you want to search.

####What you get

In response to your request we output json that represents the books of the author. An example of the output for the author "Joe Smith" is:

```
{
	"request":{
		"authentication":"true", 
	 	"key":"FCu2HvScdASGklfD1GmDBg",
	 	"method":"author_list"
    },
	"author":{
		"id":"14463184",
		"name":"Joe Smith",
		"role":null,
		"imageUrl":null,
		"smallImageUrl":null,
		"link":"https://www.goodreads.com/author/show/14463184.Joe_Smith",
		"averageRating":null,
		"ratingsCount":null,
		"textReviewsCount":null,
		"books":{
			"book":[{
				"id":{
					"value":"1110882",
					"type":"integer"
				},
				"isbn":"044651232X",
				"isbn13":"9780446512329",
				"textReviewsCount":{
					"value":"3",
					"type":"integer"
				},
				"title":"Off The Record: An Oral History Of Popular Music",
				"imageUrl":"https://d.gr-assets.com/books/1371827129m/1110882.jpg",
				"smallImageUrl":"https://d.gr-assets.com/books/1371827129s/1110882.jpg",
				"largeImageUrl":"",
				"link":"https://www.goodreads.com/book/show/1110882.Off_The_Record",
				"numPages":"429",
				"format":"Hardcover",
				"editionInformation":"",
				"publisher":"Warner Books",
				"publicationDay":"",
				"publicationYear":"1988",
				"publicationMonth":"",
				"averageRating":"3.71",
				"ratingsCount":"21",
				"description":"Stories told to Joe Smith ; edited by Mitchell Fink.",
				"authors":{
					"author":{
						"id":"14463184",
						"name":"Joe   Smith",
						"role":"",
						"imageUrl":{
							"value":"https://s.gr-assets.com/assets/nophoto/user/u_200x266-e183445fd1a1b5cc7075bb1cf7043306.png",
							"nophoto":"true"
						},
						"smallImageUrl":{
							"value":"https://s.gr-assets.com/assets/nophoto/user/u_50x66-632230dc9882b4352d753eedf9396530.png",
							"nophoto":"true"
						},
						"link":"https://www.goodreads.com/author/show/14463184.Joe_Smith",
						"averageRating":"3.71",
						"ratingsCount":"21",
						"textReviewsCount":"5",
						"books":null
					}
				},
				"published":"1988"
			}],
			"start":"1",
			"end":"1",
			"total":"1"
		}
	}
}
```