@tag
Feature: PowerKiosk Management system
#
  #@Promotion @EnrollmentOpenToAllValidationGatewayCallLog
  #Scenario: Create a new Promotion with only General information and fill enrollment and OpenToAll and GatewayCallLog(TC056)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create a point add type prize
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
    #And Validate the Gateway call log
    #
    #
     #@Promotion @Test
  #Scenario: Create a new Promotion with only General information(TC121)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #
#
#
  #@Promotion @EnrollmentOpenToAllValidationGatewayCallLog
  #Scenario: Create a new Promotion with only General information and fill enrollment and OpenToAll and GatewayCallLog(TC061)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create Prize Comp Add type prize
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
    #And Validate the Gateway call log Prize Comp
#
  #@Promotion @SlotFreePlayValidation
  #Scenario: Create a new Promotion with only General information and fill enrollment and SlotFreePlay Validation(TC118)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create Prize Slot Free Play type prize
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
    #And Validate the Gateway call log for SlotFreePlay
#
#
  #@Promotion @PrizeDrawingEntry
  #Scenario: Create a new Promotion with only General information and create a prize with Prize Drawing Entry(TC119)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create Prize Drawing Entry type prize
    #And User participate in drawing entries and promotion with 'aa' macaddress and has won 'TRUE'
#
#
  #@Promotion @PrizePromotionEnrollment
  #Scenario: Create a new Promotion with only General information and create a prize with Promotion Enrollment(TC120)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion with Import PlayerID
    #And Create a point add type prize
    #And Click on create new promotion
    #And Fill the general information of promotion to be created for promo
    #And Fill the enrollment details for the promotion with OpenToAll for promo
    #And Create a new Prize Promotion Enrollment type prize
    #And User participate in promotion enrollment type with 'aa' macaddress and has won 'TRUE'
#		And Validate the playerID in PromoList
#
  #@Promotion @EnrollmentOpenToAllValidationGatewayCallLogReports
  #Scenario: Create a new Promotion with only General information and fill enrollment and OpenToAll and Gateway Call Log and Reports(TC071)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create a point add type prize
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
    #And Validate the Gateway call log
    #And Validate the Prize Distribution Reports
#
  #@Promotion @QualificationValidationPromoTimePromoValidation
  #Scenario: Create a new Promotion with only General information and fill enrollment and Add Qualification Validation Promo Time Promo validation(TC105)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the add qualification values with LifeTime and participation promo
    #And Create a point add type prize
    #And User participate in promotion period twice with 'aa' macaddress and has won 'TRUE'
#
  #@Promotion @EnrollmentOpenToAllAndParticipateAgainValidation
  #Scenario: Create a new Promotion with only General information and fill enrollment and participate again(TC039)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create a point add type prize
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
    #Then Again participate in promotion with 'aa' macAddress and has won 'TRUE'
#
  #@Promotion @QualificationValidationMultiplePromoPeriod
  #Scenario: Create a new Promotion with only General information and fill enrollment and Add Qualification Validation Promo Multiple Period(TC114)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created with period
    #And Fill the add qualification values with LifeTime and participation
    #And Create a point add type prize
    #And User participate in promotion period which is not valid and participate with 'aa' macaddress and has won 'TRUE'
#
  #@Promotion @EnrollmentAddQualificationValidationGatewayCallLogReports
  #Scenario: Create a new Promotion with only General information and fill enrollment and Add Qualification Validation Gateway Call Log and Reports(TC075)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the add qualification values with LifeTime
    #And Create a point add type prize
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
    #And Validate the Gateway call log
#
  #@Promotion @EnrollmentImportPlayerID
  #Scenario: Create a new Promotion with only General information and fill enrollment and Import PlayerID(TC011)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion with Import PlayerID
    #And Excluded user participate in promotion with 'aa' macaddress and has won 'TRUE'
#
  #@Promotion @EnrollmentAddMultipleQualificationValidation
  #Scenario: Create a new Promotion with only General information and fill enrollment and Add Multiple Qualification Validation(TC038)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the add qualification values with LifeTime
    #And Fill the add qualification values again with Or
    #And Create a point add type prize
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
#
  #@Promotion @EnrollmentAddMultipleQualificationExcludeValidationGatewayCallLogReports
  #Scenario: Create a new Promotion with only General information and fill enrollment and Add Multiple Qualification Exclude Validation Gateway Call Log and Reports(TC081)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the add qualification values with LifeTime
    #And Fill the add qualification values again with and
    #And Create a point add type prize
    #And Excluded user participate in promotion with 'aa' macaddress and has won 'TRUE'
#
  #@Promotion @UseEnrollmentGroupsImportPlayerIDQualificationValidaion
  #Scenario: Create a new Promotion with only General information and Use enrollment groups with Import Player ID and Qualification Validation(TC065)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill using the enrollment group with playerID and qualification
    #And Create a point add type prize for enrollment group
    #And User validate the enrollment group 'aa' macaddress and has won 'TRUE'
    #And Validate the Gateway call log
    #And Validate the Player Activity Reports
    #And Validate the Prize Distribution Reports
#
  #@Promotion @UseEnrollmentGroupsTierMultipleQualificationValidation
  #Scenario: Create a new Promotion with only General information and Use enrollment groups with another Tier and Multiple Qualification Validation(TC117)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill using the enrollment group with another tier and multiple qualification
    #And Create a point add type prize for enrollment group
    #And User does not validate the enrollment group 'aa' macaddress and has won 'TRUE'
#
  #@Promotion @AlreadyParticipatedAssets
  #Scenario: Create a new Promotion with only General information and upload Already Participated assests(TC028)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #Then Fill the general information of promotion to be created and upload Already Participated assests
#
  #@Promotion @UniversalPrizesAssets
  #Scenario: Create a new Promotion with only General information and upload Universal Prize Assets(TC095)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #Then Fill the general information of promotion to be created and upload Universal Prize Assets
#
  #@Promotion @PrizeQualificationStartDateCurrent
  #Scenario: Create a new Promotion with only General information and fill enrollment and Add Prize Qualification Validation with Start Date Current date(TC111)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create a point add type prize with qualification
    #And User validates the prizes based on the 'aa' macaddress and has won 'TRUE'
#
