from ast import List
import time
from selenium import webdriver
from selenium.webdriver.common.by import By
import pytest
from selenium.webdriver.support.select import Select

driver = webdriver.Chrome()

@pytest.fixture
def var_url():
    url = "http://webdriveruniversity.com/index.html"    
    return url


def test_launch_app(var_url):
    driver.maximize_window()
    driver.get(var_url)
    driver.implicitly_wait(10)


def test_verify_page_title():
    pageTitle = driver.title
    print("Main page title:", pageTitle)
    titleToBeVerified = "WebDriverUniversity.com"
    assert pageTitle == titleToBeVerified, "Main page verification failed......"
    print("Main page verification passed!\n")
    
    
def test_dropDown_checkBoxes_radioButton_Link():
    dropDownCheckBoxesRadioButtonsLink = driver.find_element(By.XPATH, "//div//a[@id='dropdown-checkboxes-radiobuttons']")
    dropDownCheckBoxesRadioButtonsLink.click()


def test_check_switched_to_new_tab():
    time.sleep(4)
    driver.switch_to.window(driver.window_handles[1])
    pageTitleAfterSwitchedToNewTab = driver.title
    print("Page title after switching to new window:", pageTitleAfterSwitchedToNewTab)
    titleToBeVerified = "WebDriver | Dropdown Menu(s) | Checkboxe(s) | Radio Button(s)"
    assert pageTitleAfterSwitchedToNewTab == titleToBeVerified, "Page verification failed after switching to new tab......"
    print("Page verification passed after switching to second tab!\n")
    
    
def test_select_dropDown_values():
    dropDownOption1 = Select(driver.find_element(By.XPATH, "//select[@id='dropdowm-menu-1']"))
    toSelectValue1 = "Python"
    dropDownOption1.select_by_visible_text(toSelectValue1)
    selectedValue1 = dropDownOption1.first_selected_option.text
    assert selectedValue1 == toSelectValue1, "Selected value doesn't match with the expected value to select......"
    print("Selected value for drop-down 1:", selectedValue1, "\n")
    time.sleep(1)
    dropDownOption2 = Select(driver.find_element(By.XPATH, "//select[@id='dropdowm-menu-2']"))
    toSelectValue2 = "TestNG"
    dropDownOption2.select_by_visible_text(toSelectValue2)
    selectedValue2 = dropDownOption2.first_selected_option.text
    assert selectedValue2 == toSelectValue2, "Selected value doesn't match with the expected value to select......"
    print("Selected value for drop-down 2:", selectedValue2, "\n")
    time.sleep(1)
    dropDownOption3 = Select(driver.find_element(By.XPATH, "//select[@id='dropdowm-menu-3']"))
    toSelectValue3 = "JavaScript"
    dropDownOption3.select_by_visible_text(toSelectValue3)
    selectedValue3 = dropDownOption3.first_selected_option.text
    assert selectedValue3 == toSelectValue3, "Selected value doesn't match with the expected value to select......"
    print("Selected value for drop-down 3:", selectedValue3, "\n")
    time.sleep(1)
    
    
def test_select_and_verify_checkBoxes():
    checkBoxes = driver.find_elements(By.XPATH, "//div[@id='checkboxes']//child::input")
    checkedCount = 0
    unCheckedCount = 0
    for listElement in checkBoxes:
        listElement.click()
        status = listElement.get_attribute("checked")
        if status == "true" :
            checkedCount = checkedCount + 1
            print(listElement.get_attribute("value"),"is Checked")
        else:
            unCheckedCount = unCheckedCount + 1
            print(listElement.get_attribute("value"),"is Unchecked")
    print("\n", "Total count of checked values: ", checkedCount)
    print("Total count of unChecked values: ", unCheckedCount, "\n")
    time.sleep(1)
    
    
def test_select_and_verify_radioButtons():
    radioButtons = driver.find_elements(By.XPATH, "//*[@id='radio-buttons']//child::input")
    selectedCount = 0
    unSelectedCount = 0
    for listElement in radioButtons:    
        if unSelectedCount > 0 :
            print(listElement.get_attribute("value"),"radio button is not selected")
        if selectedCount == 0 :
            selectedCount = selectedCount + 1
            listElement.click()
            print(listElement.get_attribute("value"),"radio button is selected")
        unSelectedCount = unSelectedCount + 1
    print("\n", "Total count of selected radio button: ", selectedCount)
    print("Total count of unSelected radio button: ", (unSelectedCount - selectedCount), "\n")
    time.sleep(1)