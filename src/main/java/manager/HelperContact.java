package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperContact extends HelperBase {

    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openContactForm() {
        click(By.xpath("//a[text()='ADD']"));
    }

    public void fillContactForm(Contact contact) {
        type(By.xpath("//input[@placeholder='Name']"), contact.getName());
        type(By.xpath("//input[@placeholder='Last Name']"), contact.getLastName());
        type(By.xpath("//input[@placeholder='Phone']"), contact.getPhone());
        type(By.xpath("//input[@placeholder='email']"), contact.getEmail());
        type(By.xpath("//input[@placeholder='Address']"), contact.getAddress());
        type(By.xpath("//input[@placeholder='description']"), contact.getDescription());
    }


    public void saveContact() {
        getScreenElement("C:\\Users\\97253\\Documents\\QA37Auto\\QA37_PhoneBook\\src\\test\\screenshots\\screen-btn.png", By.xpath("//*[text()='Save']"));
        click(By.xpath("//*[text()='Save']"));
    }

    public boolean isActiveContacts() {
        return isElementPresent(By.xpath("//*[@class='active'][text()='CONTACTS']"));
    }

    public boolean isContactAddByName(String name) {
        List<WebElement> list = wd.findElements(By.cssSelector("h2"));
        for (WebElement el : list) {
            if (el.getText().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean isContactAddByPhone(String phone) {
        List<WebElement> list = wd.findElements(By.cssSelector("h3"));
        for (WebElement el : list) {
            if (el.getText().equals(phone)) {
                return true;
            }
        }
        return false;
    }

    public void selectContact() {
        click(By.xpath("//h3"));

    }

    public void submitDeleteContact() {
        click(By.xpath("//button[text()='Remove']"));
    }

    public int listContactSize() {
        List<WebElement> list = wd.findElements(By.xpath("//h3"));
        return list.size();
    }

    public void deleteAllContact() {
        submitDeleteContact();
        List<WebElement> list = wd.findElements(By.xpath("//h3"));

        for (int i = 0; i < list.size() - 1; i++) {
            selectContact();
            submitDeleteContact();
            pause(3000);
        }
    }

    public String getMessage() {
        return wd.findElement(By.xpath("//h1[text()=' No Contacts here!']")).getText();
    }

    public void provideContacts() {
        List<WebElement> list = wd.findElements(By.xpath("//h3"));

        int i = list.size();
        if (i < 3) {
            while (i != 3) {
                addContact();
                pause(3000);
                i++;
            }
        }
    }

    public void addContact() {
        int i = (int) System.currentTimeMillis() / 1000;
        Contact contact = Contact.builder()
                .name("Vera1")
                .lastName("Salt")
                .phone("972345" + i)
                .email("v.salt" + i + "@gmail.com")
                .address("Tel-Aviv")
                .description("The best friend")
                .build();
        openContactForm();
        fillContactForm(contact);
        saveContact();
    }

    public int removeOneContact(){
        int before = countOfContacts();
        logger.info("Number of Contacts list before remove is ---> " + before);
        removeContact();

        int after = countOfContacts();
        logger.info("Number of Contacts list after remove is ---> " + after);
        return before - after;
    }

    private void removeContact() {
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[text()='Remove']"));
        pause(1000);

    }

    private int countOfContacts() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
    }

    public void removeAllContacts() {
        while(wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size() !=0){
            removeContact();
        }
    }
}
