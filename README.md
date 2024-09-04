# RAKHINE<=>MYANMAR TRANSLATOR
>**Author:** Kyaw Zaya\
>**Language:** [Java RMI](https://docs.oracle.com/javase/8/docs/technotes/guides/rmi/index.html), [JavaFX](https://openjfx.io/)\
>**Description:** We make this project for **CST-4211** (4<sup>th</sup> Year, 2<sup>nd</sup> Semester).\
>**Version:** 1.0.0\
>**Date:** 2024-08-21\
>**Phone:** +959405999313\
>**Email:** kyawzaya@ucspathein.edu.mm\
>**Repository:** https://github.com/yaachay/Rakhine-Myanmar-Translator

### Guides to run this project
<details>
<summary>Download Requirements</summary>

+ [Eclipse IDE](https://www.eclipse.org/downloads/)
+ [Java JDK](https://www.oracle.com/java/technologies/downloads/)
+ [JavaFX](https://gluonhq.com/products/javafx/)
+ [MySQL Connector](https://dev.mysql.com/downloads/connector/j/)
+ [JSON](https://download.oracle.com/otndocs/jcp/json_p-1_1-final-spec/index.html)
> ***Note:*** You can find all requirements for **JavaFX, MySQL Connector and JSON** under `Project\lib` dictroy.
</details>
<details>
<summary>Setup Requirements</summary>

+ [Eclipse IDE Installation](#install-eclipse) 
+ [Java JDK Installation](#install-java-jdk)
+ [Setup JavaFX ](#setup-javafx)
+ [Setup MySQL Connector](#setup-mysql-connector)
+ [Setup JSON](#setup-json)
</details>
<details>
<summary>Running the Project</summary>

+ [Running Server](#running-server)
+ [Running Client](#running-client)
</details>
<h2 id="setup-javafx">Setup JavaFX</h2>

1. Firstly, you need to **copy** `javafx-sdk-22.0.2` folder from `Project\lib`.
2. Then, go to Java dirctory (for me: `C:\Program Files\Java\`) and **paste**  the folder that we copied.
3. After all, open the project in **EclipseIDE**.
![alt text](<./assets/01.png>)
1. Then, open `Window>Preferences` 
![alt text](<./assets/02.png>)
1. Go to `Java>Build Path>User Libraries`
![alt text](<./assets/03.png>)
1. Click `New` to clreate new library and enter library name `JavaFX`. Then click `OK`.
 ![alt text](<./assets/04.png>)
1. Select `JavaFX` and click `Add External JARs`.
![alt text](<./assets/05.png>)
1. Then go to `C:\Program Files\Java\javafx-sdk-22.0.2\lib\` and select **all files**. After that click `Open`.
![alt text](<./assets/06.png>)
<br>
<h2 id="setup-mysql-connector">Setup MySQL Connector</h2>

1. After creating **JavaFX** library, create new library name `MySQL Connenctor`.
![alt text](<./assets/07.png>)
1. Select `MySQL Connenctor` and click `Add External JARs`.
![alt text](<./assets/08.png>)
1. Then go to `Project\lib\` and select **jar** file for `mysql-connector`. After that click `Open`.
![alt text](<./assets/09.png>)
<br>
<h2 id="setup-json">Setup JSON</h2>

1. After creating **MySQL Connector** library, create new library name `JSON`.
![alt text](<./assets/10.png>)
1. Select `JSON` and click `Add External JARs`.
![alt text](<./assets/11.png>)
1. Then go to `Project\lib\` and select **jar** file for `json`. After that click `Open`.
![alt text](<./assets/12.png>)
<br>
<hr>
<h2 id="running-server">Running Server</h2>

1. Before you run server, you need to **add libraries** to the project. To add libraries, `right-click` on the project and click `Build Path>Configure Build Path..`
![alt text](<./assets/13.png>)
2. Then, go to `Java Build Path>Libraries>` and select `Classpath` and then click `Add Library`.
![alt text](<./assets/14.png>)
3. After that, select `User Library` and click `Next`. 
![alt text](<./assets/15.png>)
4. Then, select user libraries (**JavaFX, MySQL Connector, JSON**) and then click `Finished`.
![alt text](<./assets/16.png>)
5. After **adding libraries**, click `Apply and Close`.
![alt text](<./assets/17.png>)
6. Now, you can run server by doing some task. <br> **Right-click** on `TranslatorServer.java` and then click `Run As>Run Configurations`
![alt text](<./assets/18.png>)
7. After that,  select `TranslatorServer` under `Java Application` section on the left side and go to `Dependencies` tab on the right side. Then  select `Classpath Entries` and click `Advanced`.
![alt text](<./assets/19.png>)
8. Then, select `Add Library` and click `OK`.
![alt text](<./assets/20.png>)
9. After that, select `User Library` and click `Next`.
![alt text](<./assets/21.png>)
10. Select 2 librabies (`JSON`,`MySQL Connector`)  and click `Finish`
![alt text](<./assets/22.png>)
11.  After all, click `Run` to run the server.
![alt text](<./assets/23.png>)
12.  The server will start as shown below.
![alt text](<./assets/24.png>)
<br>
<h2 id="running-client">Running Client</h2>

1. To run client, you need to **add libraries** to the project. To add libraries, `right-click` on `Main.java` and then click `Run As>Run Configurations`
![alt text](<./assets/25.png>)
2. After that,  select `Main` under `Java Application` section on the left side and go to `Dependencies` tab on the right side. Then  select `Modulepath Entries` and click `Advanced`.
![alt text](<./assets/26.png>)
3. Then, select `Add Library` and click `OK`.
![alt text](<./assets/27.png>)
4. After that, select `User Library` and click `Next`.
![alt text](<./assets/28.png>)
5.  Select 2 librabies (`JSON`,`MySQL Connector`)  and click `Finish`
![alt text](<./assets/29.png>)
6.   After all, click `Run` to run the server.
![alt text](<./assets/30.png>)
7.   The server will start as shown below.
![alt text](<./assets/31.png>)
>**`Note`:** You can **run easily** without doing any setup for the next times. 
![alt text](<./assets/to-run-again.png>)
<br>