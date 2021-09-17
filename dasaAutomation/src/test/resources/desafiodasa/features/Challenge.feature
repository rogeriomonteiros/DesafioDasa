# encoding: utf-8

@dasa
Feature: Portal Navigation
   
	Scenario: Validate Company Redirect Page
		Given I Navigate To "http://www.dasa.com.br"
    And I Navigate To Our Brands Page
    When I Select "São Paulo" Region 
    Then I Print Filtered Labs On Console
    When I Select "delboniauriemo.com.br" Lab
    Then I Verify If I Navigated To "https://delboniauriemo.com.br/"