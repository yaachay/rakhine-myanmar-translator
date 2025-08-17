# RAKHINE <=> MYANMAR TRANSLATOR
> **Author:** Kyaw Zaya  
> **Languages Used:** [Java RMI](https://docs.oracle.com/javase/8/docs/technotes/guides/rmi/index.html), [JavaFX](https://openjfx.io/)  
> **Description:** This project was developed for **CST-4211** (4<sup>th</sup> Year, 2<sup>nd</sup> Semester).  
> **Version:** 1.0.0  
> **Date:** 2024-08-21  
> **Phone:** +959405999313  
> **Email:** kyawzaya@ucspathein.edu.mm  
> **Repository:** [GitHub Link](https://github.com/yaachay/Rakhine-Myanmar-Translator)  

---

### Project Setup Guide  

<details>
<summary><b>Download Requirements</b></summary>

+ [Eclipse IDE](https://www.eclipse.org/downloads/)  
+ [Java JDK](https://www.oracle.com/java/technologies/downloads/)  
+ [JavaFX](https://gluonhq.com/products/javafx/)  
+ [MySQL Connector](https://dev.mysql.com/downloads/connector/j/)  
+ [JSON](https://download.oracle.com/otndocs/jcp/json-p-1_1-final-spec/index.html)  

> **Note:** All required libraries (**JavaFX, MySQL Connector, JSON**) are also included under the `Project\lib` directory.  

</details>

<details>
<summary><b>Setup Requirements</b></summary>

+ [Install Eclipse IDE](#install-eclipse)  
+ [Install Java JDK](#install-java-jdk)  
+ [Set up JavaFX](#setup-javafx)  
+ [Set up MySQL Connector](#setup-mysql-connector)  
+ [Set up JSON](#setup-json)  

</details>

<details>
<summary><b>Running the Project</b></summary>

+ [Run Server](#running-server)  
+ [Run Client](#running-client)  

</details>

---

## Setup JavaFX  

1. Copy the `javafx-sdk-22.0.2` folder from `Project\lib`.  
2. Navigate to your Java installation directory (e.g., `C:\Program Files\Java\`) and **paste** the copied folder there.  
3. Open the project in **Eclipse IDE**.  
   ![alt text](<./assets/01.png>)  
4. Go to `Window > Preferences`.  
   ![alt text](<./assets/02.png>)  
5. Navigate to `Java > Build Path > User Libraries`.  
   ![alt text](<./assets/03.png>)  
6. Click **New**, name the library `JavaFX`, then click **OK**.  
   ![alt text](<./assets/04.png>)  
7. Select `JavaFX` and click **Add External JARs**.  
   ![alt text](<./assets/05.png>)  
8. Browse to `C:\Program Files\Java\javafx-sdk-22.0.2\lib\`, select **all JAR files**, and click **Open**.  
   ![alt text](<./assets/06.png>)  

---

## Setup MySQL Connector  

1. After creating the **JavaFX** library, create a new library named `MySQL Connector`.  
   ![alt text](<./assets/07.png>)  
2. Select `MySQL Connector` and click **Add External JARs**.  
   ![alt text](<./assets/08.png>)  
3. Browse to `Project\lib\`, select the `mysql-connector` JAR file, and click **Open**.  
   ![alt text](<./assets/09.png>)  

---

## Setup JSON  

1. After creating the **MySQL Connector** library, create a new library named `JSON`.  
   ![alt text](<./assets/10.png>)  
2. Select `JSON` and click **Add External JARs**.  
   ![alt text](<./assets/11.png>)  
3. Browse to `Project\lib\`, select the `json` JAR file, and click **Open**.  
   ![alt text](<./assets/12.png>)  

---

## Running Server  

1. Before running the server, you need to **add the required libraries** to the project.  
   Right-click on the project and select `Build Path > Configure Build Path...`  
   ![alt text](<./assets/13.png>)  
2. Go to `Java Build Path > Libraries`, select `Classpath`, and click **Add Library**.  
   ![alt text](<./assets/14.png>)  
3. Choose **User Library** and click **Next**.  
   ![alt text](<./assets/15.png>)  
4. Select the libraries (**JavaFX, MySQL Connector, JSON**) and click **Finish**.  
   ![alt text](<./assets/16.png>)  
5. Click **Apply and Close**.  
   ![alt text](<./assets/17.png>)  
6. To run the server, right-click `TranslatorServer.java` and select `Run As > Run Configurations`.  
   ![alt text](<./assets/18.png>)  
7. Select `TranslatorServer` under `Java Application`, go to the `Dependencies` tab, select `Classpath Entries`, and click **Advanced...**.  
   ![alt text](<./assets/19.png>)  
8. Choose **Add Library** and click **OK**.  
   ![alt text](<./assets/20.png>)  
9. Select **User Library** and click **Next**.  
   ![alt text](<./assets/21.png>)  
10. Select the required libraries (`JSON`, `MySQL Connector`) and click **Finish**.  
    ![alt text](<./assets/22.png>)  
11. Finally, click **Run** to start the server.  
    ![alt text](<./assets/23.png>)  
12. The server will start as shown below.  
    ![alt text](<./assets/24.png>)  

---

## Running Client  

1. To run the client, you must also **add the required libraries**.  
   Right-click on `Main.java` and select `Run As > Run Configurations`.  
   ![alt text](<./assets/25.png>)  
2. Select `Main` under `Java Application` in the left panel.  
   ![alt text](<./assets/26.png>)  
3. Go to the `Arguments` tab on the right. Paste the following into the **VM Arguments** box:  
```javascript
--module-path "C:\Program Files\Java\javafx-sdk-22.0.2\lib" --add-modules javafx.controls,javafx.graphics,javafx.fxml
```
![alt text](<./assets/27.png>)  

> **Note:** The `javafx-sdk-22.0.2` folder must be placed under `C:\Program Files\Java\`.  
> If it is stored elsewhere, replace the path with your custom JavaFX SDK directory.  

4. Go to the `Dependencies` tab, select `Modulepath Entries`, and click **Advanced...**.  
![alt text](<./assets/28.png>)  
5. Select `Add Library > User Library`, then choose `JavaFX` and click **Finish**.  
![alt text](<./assets/31.png>)  
6. Click **Run** to start the client. The app will launch as shown below.  
![alt text](<./assets/33.png>)  

> **Note:** After the first configuration, you can run the client easily without repeating these steps.  
![alt text](<./assets/to-run-again.png>)  

---

