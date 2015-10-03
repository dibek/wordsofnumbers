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
      | fourteen   |
      | thirty three |
      | fifty five  |

    Then The transformation of the element in the number list should give the the list in words list