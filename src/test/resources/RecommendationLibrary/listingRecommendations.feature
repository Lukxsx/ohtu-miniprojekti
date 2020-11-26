Feature: As a user I want to be able to see my recommendations

	@problem
    Scenario: user can list added recommendations
        Given command add is selected
        When book recommendation with author "AuthorTest", title "TitleTest", description "DescriptionTest", and isbn "isbnTest" is added
		And command list is selected
        Then app lists a recommendation with author "AuthorTest", title "TitleTest", description "DescriptionTest", and isbn "isbnTest"