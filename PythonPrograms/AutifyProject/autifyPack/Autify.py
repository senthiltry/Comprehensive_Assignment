from selenium import webdriver
from selenium.webdriver.common.by import By

url = "https://autify.com/"
driver = webdriver.Chrome()
homepage_text_before_switching_language = ""
homepage_text_after_switching_language = ""


def test_launch_app():
    driver.maximize_window()
    driver.get(url)


def test_verify_logo():
    element = driver.find_element(By.XPATH, "//div//a//child::img[contains(@src,'Autify-Logo')]")
    display_status = element.is_displayed()
    assert display_status == True
    print("Logo displayed:", display_status)


def test_switch_language():
    home_page_text_element = driver.find_element(By.XPATH, "//div//child::p[contains(@class,'header-msg')]")
    homepage_text_before_switching_language = home_page_text_element.text
    print("Home page text before switching the language:", homepage_text_before_switching_language)
    language_drop_down_element = driver.find_element(By.XPATH, "(//a[@id='navbarDropdownMenuLink'])[1]")
    language_drop_down_element.click()
    language_value_element = driver.find_element(By.XPATH,
                                                 "(//div[contains(@class,'dropdown-menu')]//child::a[contains(@href,'autify.com/ja/')])[1]")
    language_value_element.click()


def test_verify_webpage_language_changed_successfully():
    home_page_text_element = driver.find_element(By.XPATH, "//div//child::p[contains(@class,'header-msg')]")
    homepage_text_after_switching_language = home_page_text_element.text
    print("Home page text after switching the language:", homepage_text_after_switching_language)
    status = homepage_text_before_switching_language != homepage_text_after_switching_language
    assert status == True
    print("Language changed successfully?:", status)

# launch_app()
# verify_logo()
# switch_language()
# verify_webpage_language_changed_successfully()
