Feature: I transform a list of number in the english words

  Scenario: I try the numbers smaller then 10

    Given I have a list of numbers
      | 1 |
      | 3 |
      | 5 |

    And I have a list of words
      | one   |
      | three |
      | five  |

    Then The transformation of the element in the number list should give the the list in words list

  Scenario: I try the numbers bigger then 10

    Given I have a list of numbers
      | 14 |
      | 33 |
      | 55 |

    And I have a list of words
      | fourteen     |
      | thirty three |
      | fifty five   |

    Then The transformation of the element in the number list should give the the list in words list


  Scenario: I try the numbers bigger then 100

    Given I have a list of numbers
      | 104 |
      | 105 |
      | 230 |

    And I have a list of words
      | one hundred and four |
      | one hundred and five |
      | two hundred and thirty   |

    Then The transformation of the element in the number list should give the the list in words list


  Scenario: I try the numbers bigger then 1000

    Given I have a list of numbers
      | 1004 |
      | 1105 |
      | 2300 |

    And I have a list of words
      | one thousand and four             |
      | one thousand one hundred and five |
      | two thousand three hundred        |

    Then The transformation of the element in the number list should give the the list in words list


  Scenario: I try the example data

    Given I have a list of numbers
      | 0        |
      | 1        |
      | 21       |
      | 105      |
      | 123      |
      | 1005     |
      | 1042     |
      | 1105     |
      | 56945781 |
    And I have a list of words
      | zero                                                                                |
      | one                                                                                 |
      | twenty one                                                                          |
      | one hundred and five                                                                |
      | one hundred and twenty three                                                        |
      | one thousand and five                                                               |
      | one thousand and forty two                                                          |
      | one thousand one hundred and five                                                   |
      | fifty six million nine hundred and forty five thousand seven hundred and eighty one |


    Then The transformation of the element in the number list should give the the list in words list

  Scenario: I try the big numbers

    Given I have a list of numbers
      | 945781 |
      | 56945781 |
    And I have a list of words
      | nine hundred and forty five thousand seven hundred and eighty one |
      | fifty six million nine hundred and forty five thousand seven hundred and eighty one |


    Then The transformation of the element in the number list should give the the list in words list