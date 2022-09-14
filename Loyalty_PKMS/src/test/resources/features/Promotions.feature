@tag
Feature: PowerKiosk Management system

  #@Promotion @OutOfPrize
  #Scenario: Create a new Promotion with prize and participate till it goes out of prize(TC003)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create a point add type prize
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
    #Then Again participate in promotion with 'aa' macAddress and has won 'TRUE'
#
  #@Promotion @EnrollmentRestricted
  #Scenario: Create a new Promotion with prize and verify enrollment restriction(TC004)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Restrict a user by excluding enrollement
    #And Create a point add type prize
    #And Excluded user participate in promotion with 'aa' macaddress and has won 'TRUE'
#
  #@Promotion
  #Scenario: Create a new Promotion with only General information(TC001)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #Then Fill the general information of promotion to be created
#
  #@InvalidDate @Promotion
  #Scenario: Create a new Promotion with only General information and invalid date,add and delete period(TC002)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #Then Fill the general information of promotion to be created with invalid date,add and delete period

  #@Promotion @NoKiosk
  #Scenario: Create a new Promotion with only General information without selecting any kiosk , post to calendar , dont show promotion tile(TC003)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #Then Fill the general information of promotion to be created without kiosk selection
    #And Validate the kiosk selection 'aa' macaddress and has won 'TRUE'
    #And Fill the enrollment details for the promotion
#
  #@Promotion @OneKiosk
  #Scenario: Create a new Promotion with only General information selecting any one kiosk , post to calendar , dont show promotion tile(TC083)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #Then Fill the general information of promotion to be created with one kiosk
    #And Validate the kiosk selection 'aa' macaddress and has won 'TRUE'
#
  #@Promotion @MultiplePeriods
  #Scenario: Create a new Promotion with only General information with Multiple Periods(TC004)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #Then Fill the general information of promotion to be created with Multiple Periods
#
  #@Promotion @InvalidImage
  #Scenario: Create a new Promotion with only General information with Invalid Image(TC005)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #Then Fill the general information of promotion to be created with Invalid Image
#
  #@Promotion @Assets
  #Scenario: Create a new Promotion with only General information and upload assests(TC006)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #Then Fill the general information of promotion to be created and upload Main assests
#
  #@Promotion @PromotionIsNotAvailableAssets
  #Scenario: Create a new Promotion with only General information and upload Promotion Is Not Available assests(TC027)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #Then Fill the general information of promotion to be created and upload Promotion Is Not Available assests
#
  #@Promotion @AlreadyParticipatedAssets
  #Scenario: Create a new Promotion with only General information and upload Already Participated assests(TC028)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #Then Fill the general information of promotion to be created and upload Already Participated assests
#
  #@Promotion @NoQualificationAssets
  #Scenario: Create a new Promotion with only General information and upload No Qualification assests(TC029)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #Then Fill the general information of promotion to be created and upload No Qualification assests
#
  #@Promotion @OutOfPrizesAssets
  #Scenario: Create a new Promotion with only General information and upload Out Of Prizes assests(TC030)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #Then Fill the general information of promotion to be created and upload Out Of Prizes assests
#
  #@Promotion @InvalidAssets
  #Scenario: Create a new Promotion with only General information and upload invalid assests(TC007)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #Then Fill the general information of promotion to be created and upload invalid assests
#
  #@Promotion @Enrollment
  #Scenario: Create a new Promotion with only General information and fill enrollment(TC008)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
#
  #@Promotion @EnrollmentDemographicsBirthdayDaysBeforeAfter
  #Scenario: Create a new Promotion with only General information and fill enrollment and Demographics details with Days before(TC009)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion with Demographics Birthday Days Before and Days After
    #And Excluded user participate in promotion with 'aa' macaddress and has won 'TRUE'

  #@Promotion @EnrollmentDemographicsBirthdayAgeBetweenAnd
  #Scenario: Create a new Promotion with only General information and fill enrollment and Demographics details with Birthday Age between(TC010)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion with Demographics Birthday Age Between
    #And Excluded user participate in promotion with 'aa' macaddress and has won 'TRUE'
#
  #@Promotion @EnrollmentImportPlayerID
  #Scenario: Create a new Promotion with only General information and fill enrollment and Import PlayerID(TC011)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion with Import PlayerID
    #And Excluded user participate in promotion with 'aa' macaddress and has won 'TRUE'
#
  #@Promotion @EnrollmentExcludePlayerID
  #Scenario: Create a new Promotion with only General information and fill enrollment and Exclude PlayerID(TC012)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion with Exclude PlayerID
#
  #@Promotion @EnrollmentAddQualification
  #Scenario: Create a new Promotion with only General information and fill enrollment and Add Qualification(TC013)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the add qualification values
#
  #@Promotion @Prizes
  #Scenario: Create a new Promotion with only General information and create a prize(TC014)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create a point add type prize
#
  #@Promotion @PrizesUploadPrize
  #Scenario: Create a new Promotion with only General information and upload prizes(TC015)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Upload prizes from excel
#
  #@Promotion @PrizesAddTimeBasedDisbursement
  #Scenario: Create a new Promotion with only General information and create a prize and add time disbursement(TC016)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create a point add type prize
    #Then Add Time Based Disbursement
#
  #@Promotion @PrizesCouponsVouchers
  #Scenario: Create a new Promotion with only General information and create a prize with Prizes,Coupons and Vouchers(TC017)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create Prizes, Coupons and Vouchers type prize
    #Then Add Time Based Disbursement
#
  #@Promotion @PrizeChoice
  #Scenario: Create a new Promotion with only General information and create a prize with Prize Choice(TC018)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create Prize Choice type prize
#
  #@Promotion @PrizePointDeduct
  #Scenario: Create a new Promotion with only General information and create a prize with Prize Point Deduct(TC019)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create Prize Point Deduct type prize
#
  #@Promotion @PrizeCompAdd
  #Scenario: Create a new Promotion with only General information and create a prize with Prize Comp Add(TC020)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create Prize Comp Add type prize
#
  #@Promotion @PrizeCompDeduct
  #Scenario: Create a new Promotion with only General information and create a prize with Prize Comp Deduct(TC021)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create Prize Comp Deduct type prize
#
  #@Promotion @PrizeSlotFreePlay
  #Scenario: Create a new Promotion with only General information and create a prize with Prize Slot Free Play(TC022)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create Prize Slot Free Play type prize
#
  #@Promotion @PrizePackage
  #Scenario: Create a new Promotion with only General information and create a prize with Prize Package(TC023)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create Prize Package type prize
#
  #@Promotion @PrizeDrawingEntry
  #Scenario: Create a new Promotion with only General information and create a prize with Prize Drawing Entry(TC024)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create Prize Drawing Entry type prize
#
  #@Promotion @PrizePointMultiplier
  #Scenario: Create a new Promotion with only General information and create a prize with Point Multiplier(TC025)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create Prize Point Multiplier type prize
#
  #@Promotion @PrizePromotionEnrollment
  #Scenario: Create a new Promotion with only General information and create a prize with Promotion Enrollment(TC026)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create Prize Promotion Enrollment type prize
#
  #@Promotion @EnrollmentImportPlayerIDValidation
  #Scenario: Create a new Promotion with only General information and fill enrollment and Import PlayerID(TC031)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion with Import PlayerID
    #And Create a point add type prize
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
#
  #@Promotion @EnrollmentOpenToAllValidation
  #Scenario: Create a new Promotion with only General information and fill enrollment and OpenToAll(TC032)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create a point add type prize
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
#
  #@Promotion @EnrollmentExcludePlayerIDValidation
  #Scenario: Create a new Promotion with only General information and fill enrollment and Exclude PlayerID(TC033)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion with Exclude PlayerID
    #And Create a point add type prize
    #And Validate the exclude participant 'aa' macaddress and has won 'TRUE'
#
  #@Promotion @EnrollmentDemographicsBirthdayDaysBeforeAfterValidation
  #Scenario: Create a new Promotion with only General information and fill enrollment and Demographics details with Days before(TC034)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion with Demographics Birthday Days Before and Days After
    #And Create a point add type prize
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
#
  #@Promotion @EnrollmentDemographicsBirthdayAgeBetweenAndValidation
  #Scenario: Create a new Promotion with only General information and fill enrollment and Demographics details with Birthday Age between(TC035)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion with Demographics Birthday Age Between
    #And Create a point add type prize
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
#
  #@Promotion @EnrollmentAddQualificationValidation
  #Scenario: Create a new Promotion with only General information and fill enrollment and Add Qualification Validation(TC036)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the add qualification values with LifeTime
    #And Create a point add type prize
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
#
  #@Promotion @EnrollmentAddMultipleQualification
  #Scenario: Create a new Promotion with only General information and fill enrollment and Add Multiple Qualification(TC037)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the add qualification values with LifeTime
    #And Fill the add qualification values again with Or
    #And Create a point add type prize
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
  #@Promotion @EnrollmentImportPlayerIDAndParticipateAgainValidation
  #Scenario: Create a new Promotion with only General information and fill enrollment and Import PlayerID and participate again(TC040)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion with Import PlayerID
    #And Create a point add type prize
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
    #Then Again participate in promotion with 'aa' macAddress and has won 'TRUE'
#
  #@Promotion @PointDeductValidation
  #Scenario: Create a new Promotion with only General information and fill enrollment and PointDeduct Validation(TC041)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create Prize Point Deduct type prize
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
#
  #@Promotion @CompAddValidation
  #Scenario: Create a new Promotion with only General information and fill enrollment and CompAdd Validation(TC042)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create Prize Comp Add type prize
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
#
  #@Promotion @CompDeductValidation
  #Scenario: Create a new Promotion with only General information and fill enrollment and CompDeduct Validation(TC043)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create Prize Comp Deduct type prize
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
#
  #@Promotion @SlotFreePlayValidation
  #Scenario: Create a new Promotion with only General information and fill enrollment and SlotFreePlay Validation(TC044)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create Prize Slot Free Play type prize
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
#
  #@Promotion @PrizeChoiceMultiple
  #Scenario: Create a new Promotion with only General information and create a prize with Multiple Prize Choice (TC045)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create Prize Choice type prize multiple times
#
  #@Promotion @AssignPrizesCsv
  #Scenario: Create a new Promotion with only General information and upload and Assign Prizes with csv(TC046)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create a point add type prize
    #And Upload Assign Prizes in enrollment tab with csv
#
  #@Promotion @AssignPrizes
  #Scenario: Create a new Promotion with only General information and upload and Assign Prizes (TC047)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create a point add type prize
    #And Upload Assign Prizes in enrollment tab
#
  #@Promotion @UseEnrollmentGroupsImportPlayerID
  #Scenario: Create a new Promotion with only General information and Use enrollment groups with Import Player ID (TC048)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill using the enrollment group with playerID
    #And Create a point add type prize for enrollment group
#
  #@Promotion @UseEnrollmentGroupsTier
  #Scenario: Create a new Promotion with only General information and Use enrollment groups with Tier(TC049)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill using the enrollment group with tier
    #And Create a point add type prize for enrollment group
#
  #@Promotion @UseEnrollmentGroupsQualification
  #Scenario: Create a new Promotion with only General information and Use enrollment groups with Qualification(TC050)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill using the enrollment group with qualification
    #And Create a point add type prize for enrollment group
#
  #@Promotion @UseEnrollmentGroupsImportPlayerIDQualification
  #Scenario: Create a new Promotion with only General information and Use enrollment groups with Import Player ID and Qualification(TC051)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill using the enrollment group with playerID and qualification
    #And Create a point add type prize for enrollment group
#
  #@Promotion @UseEnrollmentGroupsImportPlayerIDMultipleQualification
  #Scenario: Create a new Promotion with only General information and Use enrollment groups with Import Player ID and Multiple Qualification(TC052)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill using the enrollment group with playerID and multiple qualification
    #And Create a point add type prize for enrollment group
#
  #@Promotion @UseEnrollmentGroupsTierMultipleQualification
  #Scenario: Create a new Promotion with only General information and Use enrollment groups with Tier and Multiple Qualification(TC053)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill using the enrollment group with tier and multiple qualification
    #And Create a point add type prize for enrollment group
#
  #@Promotion @UseEnrollmentGroupsQualificationMultipleQualification
  #Scenario: Create a new Promotion with only General information and Use enrollment groups with Qualification and Multiple Qualification(TC054)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill using the enrollment group with qualification and multiple qualification
    #And Create a point add type prize for enrollment group
#
  #@Promotion @EnrollmentImportPlayerIDValidationGatewayCallLog
  #Scenario: Create a new Promotion with only General information and fill enrollment and Import PlayerID and Gateway Call Log(TC055)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion with Import PlayerID
    #And Create a point add type prize
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
    #And Validate the Gateway call log
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
  #@Promotion @EnrollmentExcludePlayerIDValidationGatewayCallLog
  #Scenario: Create a new Promotion with only General information and fill enrollment and Exclude PlayerID and GatewayCallLog(TC057)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion with Exclude PlayerID
    #And Create a point add type prize
    #And Validate the exclude participant 'aa' macaddress and has won 'TRUE'
    #And Validate the Gateway call log
#
  #@Promotion @EnrollmentDemographicsBirthdayDaysBeforeAfterValidationGatewayCallLog
  #Scenario: Create a new Promotion with only General information and fill enrollment and Demographics details with Days before and GatewayCallLog(TC058)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion with Demographics Birthday Days Before and Days After
    #And Create a point add type prize
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
    #And Validate the Gateway call log for Demographics
#
  #@Promotion @EnrollmentDemographicsBirthdayAgeBetweenAndValidationGatewayCallLog
  #Scenario: Create a new Promotion with only General information and fill enrollment and Demographics details with Birthday Age between and GatewayCallLog(TC059)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion with Demographics Birthday Age Between
    #And Create a point add type prize
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
    #And Validate the Gateway call log for Demographics
#
  #@Promotion @EnrollmentImportPlayerIDValidationGatewayCallLog
  #Scenario: Create a new Promotion with only General information and fill enrollment and Import PlayerID and Gateway Call Log(TC060)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion with Import PlayerID
    #And Create Prize Comp Deduct type prize
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
    #And Validate the Gateway call log Prize Comp
#
  @Promotion @EnrollmentImportPlayerIDValidationGatewayCallLog
  Scenario: Create a new Promotion with only General information and fill enrollment and Import PlayerID and Gateway Call Log and validate the imported playerid(TC116)
    Given Login in to PKMS system to land on home page
    And Click on create new promotion
    And Fill the general information of promotion to be created
    And Fill the enrollment details for the promotion with Import PlayerID
    And Create a point add type prize
    And Validate the exclude participant condition with 'aa' macaddress and has won 'TRUE'
    And Validate the Gateway call log

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
  #@Promotion @EnrollmentExcludePlayerIDValidationGatewayCallLog
  #Scenario: Create a new Promotion with only General information and fill enrollment and Exclude PlayerID and GatewayCallLog(TC062)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion with Exclude PlayerID
    #And Create Prize Comp Add type prize
    #And Validate the exclude participant 'aa' macaddress and has won 'TRUE'
#
  #@Promotion @EnrollmentExcludePlayerIDValidationGatewayCallLog
  #Scenario: Create a new Promotion with only General information and fill enrollment and Exclude PlayerID and GatewayCallLog to validate excluded playerid(TC115)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion with Exclude PlayerID
    #And Create Prize Comp Add type prize
    #And Validate the exclude participant condition with 'aa' macaddress and has won 'TRUE'
    #And Validate the Gateway call log
#
  #@Promotion @EnrollmentDemographicsBirthdayDaysBeforeAfterValidationGatewayCallLog
  #Scenario: Create a new Promotion with only General information and fill enrollment and Demographics details with Days before and GatewayCallLog(TC063)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion with Demographics Birthday Days Before and Days After
    #And Create Prize Comp Add type prize
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
    #And Validate the Gateway call log Prize Comp
#
  #@Promotion @EnrollmentDemographicsBirthdayAgeBetweenAndValidationGatewayCallLog
  #Scenario: Create a new Promotion with only General information and fill enrollment and Demographics details with Birthday Age between and GatewayCallLog(TC064)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion with Demographics Birthday Age Between
    #And Create Prize Comp Add type prize
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
    #And Validate the Gateway call log Prize Comp
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
  #@Promotion @UseEnrollmentGroupsImportPlayerIDMultipleQualificationValidation
  #Scenario: Create a new Promotion with only General information and Use enrollment groups with Import Player ID and Multiple Qualification Validation(TC066)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill using the enrollment group with playerID and multiple qualification
    #And Create a point add type prize for enrollment group
    #And Validate the filter options in the prize screen
    #And User validate the enrollment group 'aa' macaddress and has won 'TRUE'
    #And Validate the Gateway call log
    #And Validate the Player Activity Reports
    #And Validate the Prize Distribution Reports
#
  #@Promotion @UseEnrollmentGroupsTierMultipleQualificationValidation
  #Scenario: Create a new Promotion with only General information and Use enrollment groups with Tier and Multiple Qualification Validation(TC067)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill using the enrollment group with tier and multiple qualification
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
  #@Promotion @UseEnrollmentGroupsQualificationMultipleQualification
  #Scenario: Create a new Promotion with only General information and Use enrollment groups with Qualification and Multiple Qualification(TC068)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill using the enrollment group with qualification and multiple qualification
    #And Create a point add type prize for enrollment group
    #And User does not validate the enrollment group 'aa' macaddress and has won 'TRUE'
#
  #@Promotion @UseEnrollmentGroupsImportPlayerIDMultipleQualificationValidation
  #Scenario: Create a new Promotion with only General information and Use enrollment groups with Import Player ID and not in other group and Multiple Qualification Validation(TC069)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill using the enrollment group with playerID and not in other group and multiple qualification
    #And Create a point add type prize for enrollment group
    #And User validate the enrollment group 'aa' macaddress and has won 'TRUE'
    #And Validate the Gateway call log
    #And Validate the Player Activity Reports
    #And Validate the Prize Distribution Reports
#
  #@Promotion @EnrollmentImportPlayerIDValidationGatewayCallLogReports
  #Scenario: Create a new Promotion with only General information and fill enrollment and Import PlayerID and Gateway Call Log and Reports(TC070)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion with Import PlayerID
    #And Create a point add type prize
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
    #And Validate the Gateway call log
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
#
  #@Promotion @EnrollmentExcludePlayerIDValidationGatewayCallLogReports
  #Scenario: Create a new Promotion with only General information and fill enrollment and Exclude PlayerID and Gateway Call Log and Reports(TC072)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion with Exclude PlayerID
    #And Create a point add type prize
    #And Validate the exclude participant 'aa' macaddress and has won 'TRUE'
    #And Validate the Gateway call log
#
  #@Promotion @EnrollmentDemographicsBirthdayDaysBeforeAfterValidationGatewayCallLogReports
  #Scenario: Create a new Promotion with only General information and fill enrollment and Demographics details with Days before Gateway Call Log and Reports(TC073)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion with Demographics Birthday Days Before and Days After
    #And Create a point add type prize
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
    #And Validate the Gateway call log
#
  #@Promotion @EnrollmentDemographicsBirthdayAgeBetweenAndValidationGatewayCallLogReports
  #Scenario: Create a new Promotion with only General information and fill enrollment and Demographics details with Birthday Age between Gateway Call Log and Reports(TC074)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion with Demographics Birthday Age Between
    #And Create a point add type prize
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
    #And Validate the Gateway call log
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
  #@Promotion @EnrollmentAddMultipleQualificationValidationGatewayCallLogReportswithOr
  #Scenario: Create a new Promotion with only General information and fill enrollment and Add Multiple Qualification Validation Gateway Call Log and Reports(TC076)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the add qualification values with LifeTime
    #And Fill the add qualification values again with Or
    #And Create a point add type prize
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
    #And Validate the Gateway call log
    #And Validate the Prize Distribution Reports
#
  #@Promotion @EnrollmentAddMultipleQualificationValidationGatewayCallLogReportswithAnd
  #Scenario: Create a new Promotion with only General information and fill enrollment and Add Multiple Qualification Validation Gateway Call Log and Reports(TC077)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the add qualification values with LifeTime
    #And Fill the add qualification values again with and
    #And Create a point add type prize
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
    #And Validate the Gateway call log
    #And Validate the Prize Distribution Reports
#
  #@Promotion @EnrollmentCustomQueryValidationGatewayCallLogReports
  #Scenario: Create a new Promotion with only General information and fill enrollment and Custom Query Validation Gateway Call Log and Reports(TC078)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion with CustomQuery
    #And Fill the add qualification values with LifeTime
    #And Create a point add type prize
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
    #And Validate the Gateway call log
    #And Validate the Prize Distribution Reports
#
  #@Promotion @EnrollmentCustomQueryExcludeValidationGatewayCallLogReports
  #Scenario: Create a new Promotion with only General information and fill enrollment and Custom Query Exclude Validation Gateway Call Log and Reports(TC079)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion with CustomQuery
    #And Fill the add qualification values with LifeTime
    #And Create a point add type prize
    #And Excluded user participate in promotion with 'aa' macaddress and has won 'TRUE'
    #And Validate the Gateway call log
    #And Validate the Prize Distribution Reports
#
  #@Promotion @EnrollmentPostToCalendarPriority
  #Scenario: Create a new Promotion with only General information and fill enrollment and validate Priotity and Post to calendar(TC080)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created with Post to Calendar
    #And Fill the enrollment details for the promotion
    #And Validate the post to calendar and priority 'aa' macaddress and has won 'TRUE'
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
  #@Promotion @EnrollmentAddMultipleQualificationValidationGatewayCallLogReports
  #Scenario: Create a new Promotion with only General information and fill enrollment and Add Multiple Qualification Exclude Validation Gateway Call Log and Reports(TC082)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the add qualification values with LifeTime
    #And Fill the add qualification values again with Or
    #And Create a point add type prize
    #And Excluded user participate in promotion with 'aa' macaddress and has won 'TRUE'
#
  #@Promotion @EnrollmentOpenToAllValidationAdvancedConfigReveal
  #Scenario: Create a new Promotion with only General information and fill enrollment and OpenToAll and Advanced Configuration with Reveal(TC084)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create a point add type prize
    #And Add Advanced Configurations to reveal functionality
    #And Validate the Advanced Configurations with 'aa' macaddress and has won 'TRUE'
#
  #@Promotion @EnrollmentOpenToAllValidationAdvancedConfigPrizes
  #Scenario: Create a new Promotion with only General information and fill enrollment and OpenToAll and Advanced Configuration with Prizes(TC085)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create a point add type prize
    #And Add Advanced Configurations to prizes functionality
    #And Validate the Advanced Configurations with 'aa' macaddress and has won 'TRUE'
#
  #@Promotion @EnrollmentOpenToAllValidationAdvancedConfigOutputVariable
  #Scenario: Create a new Promotion with only General information and fill enrollment and OpenToAll and Advanced Configuration with Output(TC086)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create a point add type prize
    #And Add Advanced Configurations to Output functionality
    #And Validate the Advanced Configurations with 'aa' macaddress and has won 'TRUE'
#
  #@Promotion @EnrollmentOpenToAllValidationAdvancedConfigOutputVariableDelete
  #Scenario: Create a new Promotion with only General information and fill enrollment and OpenToAll and Advanced Configuration with Output and Delete(TC087)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create a point add type prize
    #And Add Advanced Configurations to Output functionality
    #And Add Advanced Configurations to reveal functionality and delete
    #And Validate the Advanced Configurations with 'aa' macaddress and has won 'TRUE'
#
  #@Promotion @PrizesUploadPrizePromoEnrollNoPrizeValue
  #Scenario: Create a new Promotion with only General information and upload prizes with Promotion Enrollment with no value of prize(TC088)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Upload prizes from excel for PromoEnrollment with no value of prize
#
  #@Promotion @PrizesUploadPrizePromoEnrollNoPromoId
  #Scenario: Create a new Promotion with only General information and upload prizes with Promotion Enrollment with no promoid(TC089)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Upload prizes from excel for PromoEnrollment with no promoid
#
  #@Promotion @PrizesUploadPrizePromoEnrollInvaliPromoId
  #Scenario: Create a new Promotion with only General information and upload prizes with Promotion Enrollment with invalid promoid(TC090)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Upload prizes from excel for PromoEnrollment with invalid promoid
#
  #@Promotion @PrizesUploadPrizeValidation
  #Scenario: Create a new Promotion with only General information and upload prizes(TC091)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Upload prizes from excel
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
    #And Validate the Gateway call log
    #And Validate the Prize Distribution Reports
#
  #@Promotion @PrizesUploadPrizePointAddNoRedeemCode
  #Scenario: Create a new Promotion with only General information and upload prizes with Point add and with no Redemption code(TC092)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Upload prizes from excel for PointAdd with No Redemption Code
#
  #@Promotion @PrizesUploadPrizePackage
  #Scenario: Create a new Promotion with only General information and upload prizes with Point Package(TC093)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Upload prizes from excel for Prize Package
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
    #And Validate the Gateway call log
    #And Validate the Prize Distribution Reports
#
  #@Promotion @PrizesUploadPrizeEnrollmentGroups
  #Scenario: Create a new Promotion with only General information and upload prizes with Enrollment Groups(TC094)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill using the enrollment group with playerID
    #And Upload prizes from excel for Prize with Enrollment Groups
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
    #And Validate the Gateway call log
    #And Validate the Prize Distribution Reports
#
  #@Promotion @UniversalPrizesAssets
  #Scenario: Create a new Promotion with only General information and upload Universal Prize Assets(TC095)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #Then Fill the general information of promotion to be created and upload Universal Prize Assets
#
  #@Promotion @PrizePackageMultipleSubprizesNoPrintSubprizes
  #Scenario: Create a new Promotion with only General information and create a prize with Prize Package with multiple subprizes with no print receipts(TC096)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create Prize Package type prize with multiple sub prizes with no print receipts
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
    #And Validate the Gateway call log
#
  #@Promotion @PrizePackageMultipleSubprizesPrintReceiptsSubprizes
  #Scenario: Create a new Promotion with only General information and create a prize with Prize Package with multiple subprizes with print receipts for subprizes(TC097)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create Prize Package type prize with multiple sub prizes with print receipts for subprizes
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
    #And Validate the Gateway call log
#
  #@Promotion @PrizePackageMultipleSubprizesPrintReceiptsAll
  #Scenario: Create a new Promotion with only General information and create a prize with Prize Package with multiple subprizes with print receipts for all(TC098)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create Prize Package type prize with multiple sub prizes with print receipts for all
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
    #And Validate the Gateway call log
#
  #@Promotion @PrizePackageMultipleSubprizesEditReceipt
  #Scenario: Create a new Promotion with only General information and create a prize with Prize Package with multiple subprizes with edit receipts(TC099)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create Prize Package type prize with multiple sub prizes with edit receipt
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
    #And Validate the Gateway call log
#
  #@Promotion @PrizePackageMultipleSubprizesEditPrize
  #Scenario: Create a new Promotion with only General information and create a prize with Prize Package with multiple subprizes with edit prize(TC100)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create Prize Package type prize with multiple sub prizes with edit prize
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
    #And Validate the Gateway call log
#
  #@Promotion @PrizePackageNoSubprizes
  #Scenario: Create a new Promotion with only General information and create a prize with Prize Package with no subprizes(TC101)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create Prize Package type prize with no sub prizes
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
#
  #@Promotion @QualificationValidationPromoPeriod
  #Scenario: Create a new Promotion with only General information and fill enrollment and Add Qualification Validation Promo Period(TC102)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the add qualification values with LifeTime and participation
    #And Create a point add type prize
    #And User participate in promotion twice with 'aa' macaddress and has won 'TRUE'
    #And Validate the Gateway call log
    #And Validate the Prize Distribution Reports
#
  #@Promotion @QualificationValidationMultiplePromoPeriod
  #Scenario: Create a new Promotion with only General information and fill enrollment and Add Qualification Validation Promo Multiple Period(TC103)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created with period
    #And Fill the add qualification values with LifeTime and participation
    #And Create a point add type prize
    #And User participate in promotion period thrice and participate with 'aa' macaddress and has won 'TRUE'
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
  #@Promotion @QualificationValidationPromoTimePromo
  #Scenario: Create a new Promotion with only General information and fill enrollment and Add Qualification Validation Promo Time Promo(TC104)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the add qualification values with LifeTime and participation promo
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
  #@Promotion @QualificationValidationTimeDay
  #Scenario: Create a new Promotion with only General information and fill enrollment and Add Qualification Validation Promo Time Day(TC106)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the add qualification values with LifeTime and participation day
    #And Create a point add type prize
    #And User participate in promotion with 'aa' macaddress and has won 'TRUE'
    #And Validate the Gateway call log
    #And Validate the Prize Distribution Reports
#
  #@Promotion @QualificationValidationTimeDayValidation
  #Scenario: Create a new Promotion with only General information and fill enrollment and Add Qualification Validation Promo Time Day Validation(TC107)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the add qualification values with LifeTime and participation day
    #And Create a point add type prize
    #And User participate in promotion period twice with 'aa' macaddress and has won 'TRUE'
#
  #@Promotion @AuditReport
  #Scenario: Create a new Promotion with only General information and AuditReport(TC108)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Validate the Audit Report
#
  #@Promotion @PrizeQualificationStartDate
  #Scenario: Create a new Promotion with only General information and fill enrollment and Add Prize Qualification Validation with StartDate greater(TC109)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create a point add type prize with qualification start date greater
#
  #@Promotion @PrizeQualificationStartDateLess
  #Scenario: Create a new Promotion with only General information and fill enrollment and Add Prize Qualification Validation with Start Date less than End Date(TC110)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create a point add type prize with qualification
    #And User validates the prizes based on the 'aa' macaddress and has won 'TRUE'
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
  #@Promotion @PrizeQualificationStartTimePast
  #Scenario: Create a new Promotion with only General information and fill enrollment and Add Prize Qualification Validation with start time greater for past date(TC112)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create a point add type prize with qualification start time greater
#
  #@Promotion @PrizeQualificationStartTimeCurrent
  #Scenario: Create a new Promotion with only General information and fill enrollment and Add Prize Qualification Validation with start time greater for current date(TC113)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create a point add type prize with qualification start time greater
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
  #@Promotion @PrizeDrawingEntry
  #Scenario: Create a new Promotion with only General information and create a prize with Prize Drawing Entry(TC119)
    #Given Login in to PKMS system to land on home page
    #And Click on create new promotion
    #And Fill the general information of promotion to be created
    #And Fill the enrollment details for the promotion
    #And Create Prize Drawing Entry type prize
    #And User participate in drawing entries and promotion with 'aa' macaddress and has won 'TRUE'
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
    #And Fill the enrollment details for the promotion with Import PlayerID for promo
    #And Create a new Prize Promotion Enrollment type prize
    #And User participate in promotion enrollment type with 'aa' macaddress and has won 'TRUE'
