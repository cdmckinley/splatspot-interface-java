# Enterprise Java course journal
Here, I'll document my progress and studies in the class.

### Before Class Began
Up to and including 8/29/2022

My memory is a bit vague, but I know I made efforts to get my environment set up.
I did most of the setup by this time, including:
- downloading the VM
- verifying MySQL was set up as instructed
- beginning IntelliJ's setup
- joining the course's GitHub Team
- probably other things I'm forgetting

### First Week
Week of 8/30-9/5 (Second day of class through Labor Day)

The transition from not having class to having class is usually tough for me. As such I didn't complete as much as I hoped this week, but I did the following:
- Finished set up on IntelliJ
- Activities 1-4
- Exercise 1

### Second Week
Week of 9/6-9/11

I've done a lot of thinking and research to determine what my individual project should be. It was a bit distracting from the week's work, but I did get the following done:
- Researched approaches to linking a TomCat servlet with a Discord application/bot
- Most of Activity 2, all except adding my name and Individual Project repository to the list
- Much discussion over what my project should be, some of how I should approach it, and requirements I will need to fulfill.

### Third Week
9/12

I've been working on catching up on last week today. I feel I've made a lot of progress for just today that includes the following:
- Activity 3
  - Created the Individual Project repository
  - Updated `pom.xml`, `web.xml`, and `.gitignore`
  - wrote a preliminary README file
  - started this journal
- Bonus: Non-Java accomplishments today (I'm in a good mood)
  - Got a review I'm writing for the newspaper to a state where it's about a paragraph away from being ready for review

9/13

Today, I'm updating my used references, based on the tabs I've been leaving open to track them more easily.
They are the following:
- The course website, Slack server, and YouTube channel
- [JetBrains page on debugging in IDEA](https://www.jetbrains.com/help/idea/debugging-your-first-java-application.html)
- Google searches which embedded information from the following
  - [Finding packages installed through apt](https://www.cyberciti.biz/faq/apt-get-list-packages-are-installed-on-ubuntu-linux/)
  - [Installing multiple packages at once](https://askubuntu.com/questions/874611/installing-multiple-packages-at-the-same-time)
  - [Upgrading packages using apt](https://itsfoss.com/apt-get-linux-guide/)
- [Enabling soft wrap](https://www.jetbrains.com/idea/guide/tips/enable-soft-wrap/#:~:text=You%20can%20enable%20soft%20wrap,more%20file%20types%20by%20default.)
- [Java Discord API](https://github.com/DV8FromTheWorld/JDA/)
- [Java Discord API tutorial](https://youtu.be/LFsxkWME7M0)

9/16-17

I got my laptop set up to work on this class.

I accomplished:
- Setting up JDK 11 and IntelliJ
- setting up Tomcat and SoapUI
- Setting up MySQL
Using the following:
- [Atlassian for JAVA_HOME](https://confluence.atlassian.com/doc/setting-the-java_home-variable-in-windows-8895.html)
- [The class's website](http://paulawaite.com/education/java113/setup/personalLaptopSetup.html)

9/17 **Part two!**

I did a lot of planning today, I:
- Created [Goals document](goals.md)
- Created [User stories](userStories.md)
- Have a [plan](planning.md)!

### Fourth Week

9/18

I mocked up a main page today! I'm proud of how much I've gotten done.

I referenced [Bootstrap's documentation](https://getbootstrap.com/docs) for (at least):
- Containers
- Background, link, and text colors
- Flex, direction, justification, and alignment
- sticky top and bottom
- spacing (margin and padding)
- borders

I also made my own logo using the [Aseprite pixel-art tool](https://www.aseprite.org/) (which I installed via the Steam store, where I had previously bought it). I kept the project file in the `media` directory, in case I need to make changes.

9/19

I worked a bit on Week 2 exercise. It's not entirely done, but progress has been made up to "next next steps" and finishing the TODOs.

I also worked on a second mockup page, using the first page as a base. I referenced:
- https://www.w3schools.com/tags/att_img_height.asp
- The following images from [Splatoon Wiki](https://splatoonwiki.org/) to represent Splatoon-series characters (most of which I found through Google Images):
  - [Crusty Sean](https://cdn.wikimg.net/en/splatoonwiki/images/thumb/b/b8/S2_crusty_sean.png/257px-S2_crusty_sean.png)
  - [Craig Cuttlefish](https://cdn.wikimg.net/en/splatoonwiki/images/thumb/6/67/Old_Inkling.jpg/300px-Old_Inkling.jpg)
  - [Big Man](https://cdn.wikimg.net/en/splatoonwiki/images/thumb/f/f0/S3_Big_Man_Render.png/501px-S3_Big_Man_Render.png)
  - A [mysterious icon](https://cdn.wikimg.net/en/splatoonwiki/images/7/74/S2_Salmon_Run_question_mark_capsule.png) to represent Mr. Grizz

I wanted to ignore the database.properties file, but it was a bit late to add to `.gitignore`, so I reset the commit:
- [Undoing a commit](https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/uncommit-git-last-commit-file-changes-pushed-deleted-message)

9/20

In finishing up exercise 2, I used:
- Java 11 Documentation
  - [Date](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Date.html)
  - [LocalDate](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/time/LocalDate.html)
  - [Instant](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/time/Instant.html)
  - [ZoneDateTime](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/time/ZonedDateTime.html)
  - [ZoneId](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/time/ZoneId.html)
  - [Period.between](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/time/Period.html#between(java.time.LocalDate,java.time.LocalDate))
- I used [Javatpoint's guide](https://www.javatpoint.com/java-calculate-age) as a guideline, though I didn't scroll down, and tried to solve the rest based mostly on my own speculation, and documentation.
- I used [Java Advent's guide](https://www.javaadvent.com/2020/12/4-ways-to-convert-date-to-localdate-in-java.html) to figure my path out from `Date` to `LocalDate`
- ...Until I realized the date of birth was a `java.sql.Date` vs `java.util.Date`, but then I fixed it thanks to [Java 11 Docs](https://docs.oracle.com/en/java/javase/11/docs/api/java.sql/java/sql/Date.html) again.
- [DataTables](https://datatables.net/) as a way to display the data

9/22

I completed Exercise 2 today! It took me longer because of different Date types, not putting a '/' in a name when calling a resource, and forgetting to save the returned value of `loadProperties` to memory. There was also other trial and error, but it's done now.
I used:
- Java 11 documentation
  - [PreparedStatement](https://docs.oracle.com/en/java/javase/11/docs/api/java.sql/java/sql/PreparedStatement.html)
  - [Connection](https://docs.oracle.com/en/java/javase/11/docs/api/java.sql/java/sql/Connection.html)
  - [HttpServletRequest](https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpRequest.html)
- TutorialsPoint
  - [It's JSTL installation guide](https://www.tutorialspoint.com/jsp/jsp_standard_tag_library.htm), but I didn't end up needing it
  - [JSTL foreach](https://www.tutorialspoint.com/jsp/jstl_core_foreach_tag.htm)
- Tomcat documentation for [ServletRequest](https://tomcat.apache.org/tomcat-7.0-doc/servletapi/javax/servlet/ServletRequest.html), in trying to find `httpServletRequest`
- [jQuery](https://releases.jquery.com/)
- w3schools
  - [HTML forms](https://www.w3schools.com/html/html_forms.asp)
  - [Form attributes](https://www.w3schools.com/html/html_forms.asp)
- as usual, the course website, slack, and videos

9/24

I've made it around halfway through Exercise 3. I wrote the first two tests confidently!
Here are the resources I used:
- Java docs
  - [For loop (for each)](https://docs.oracle.com/javase/8/docs/technotes/guides/language/foreach.html)
  - [IndexOutOfBoundsException](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/lang/IndexOutOfBoundsException.html)
    - [CodeJava's guide](https://www.codejava.net/testing/junit-test-exception-examples-how-to-assert-an-exception-is-thrown) on testing if an exception is thrown. Note: I only searched for how to assert an exception. The guide was maybe a bit too helpful with the rest of the solution, not just the name of `AssertThrows`. I did reference it for the `Executable` object.
    - For future knowledge, I did also search for [lambdas in Java](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html) as an alternative to creating an executable object.

### Fifth Week

9/27

While I was low on energy and focus the past few days, I did get some momentum today! I submitted the work for week 3!
I used the following resources:
- Java Documentation
  - [FileReader](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/FileReader.html)
  - [BufferedReader](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/BufferedReader.html)
  - [String](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html)
  - [Object](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Object.html) when trying to find `getClass`
  - [Class](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Class.html) when trying to make use of `getMethod`, when a lambda should have been used
  - [Integer](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Integer.html)
  - A guide on [Throwing](https://docs.oracle.com/javase/tutorial/essential/exceptions/throwing.html)
- [Throwing custom exceptions](https://www.geeksforgeeks.org/user-defined-custom-exception-in-java/)
- [Reading files line-by-line in Java](https://www.javatpoint.com/how-to-read-file-line-by-line-in-java) (I'd forgotten about BufferedReader)
- I also used our Slack DMs and the class website and YouTube channel

9/28

I began working on parts of my project that relate to Exercise 4 today.

I've used the following today:
- The course website
- TutorialsPoint
  - [DAO pattern](https://www.tutorialspoint.com/design_pattern/data_access_object_pattern.htm)
  - [Hibernate Tutorial](https://www.tutorialspoint.com//hibernate/index.htm)
- Took a look at [Singleton on Wikipedia](https://en.wikipedia.org/wiki/Singleton_pattern)
- A Google search for "does MySQL have booleans' suggested [this](https://blog.devart.com/mysql-data-types.html#:~:text=MySQL%20does%20not%20have%20a,%2C%20and%201%2C%20if%20true.)
- MySQL documentation
  - [Integer types](https://dev.mysql.com/doc/refman/8.0/en/integer-types.html)
  - [String types](https://dev.mysql.com/doc/refman/8.0/en/string-types.html)
  - [Char](https://dev.mysql.com/doc/refman/8.0/en/char.html)
- Java documentation
  - A [refresher](https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html#:~:text=The%20private%20modifier%20specifies%20that,its%20class%20in%20another%20package.) on `private` vs `protected` to ensure I was using the right one
  - [HashMap](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/HashMap.html)
- A Google search for "java dictionary vs map" suggested [this](https://coderanch.com/t/581116/java/Map-Dictionary)
- A Google search for "java bean requirements" suggested [this on StackOverflow](https://stackoverflow.com/questions/3295496/what-is-a-javabean-exactly)
- [POJO vs JavaBeans](https://www.geeksforgeeks.org/pojo-vs-java-beans/)

9/29

I continued working on my project through working on Exercise 4 today.

I referred to:
- The course website, YouTube channel, and Slack
- Tutorialspoint
  - Their [Hibernate tutorial](https://www.tutorialspoint.com/hibernate/index.htm)
  - Their [DAO tutorial](https://www.tutorialspoint.com/design_pattern/data_access_object_pattern.htm)
  - Their [guide on RDBMS data types](https://www.tutorialspoint.com/hibernate/hibernate_mapping_types.htm#:~:text=When%20you%20prepare%20a%20Hibernate,not%20SQL%20database%20types%20either.), or the types used in Hibernate's mapping files
- The [Hibernate guide](https://docs.jboss.org/hibernate/orm/5.4/quickstart/html_single/) linked to in the course website
- MySQL.dev
  - [Create Database](https://dev.mysql.com/doc/refman/8.0/en/create-database.html)
  - [Create Table](https://dev.mysql.com/doc/refman/8.0/en/create-table.html)
  - [Naming conventions](https://dev.mysql.com/doc/dev/mysql-server/latest/PAGE_NAMING_CONVENTIONS.html)
- [MySQL Naming Convention guide](https://courses.cs.washington.edu/courses/cse154/18sp/18sp-data/documents/styleguide/sql/naming-conventions-sql.html)
- [W3Schools' XML guide](https://www.w3schools.com/xml/xml_syntax.asp) confirmed for me that I was missing the root tag of the config file (I needed to read further down the configuration guide)
- [Atlassian's Git ignore guide](https://www.atlassian.com/git/tutorials/saving-changes/gitignore) for ignoring a fle in recursive subdirectories
- Tomcat's documentation
  - [HttpServlet](https://tomcat.apache.org/tomcat-7.0-doc/servletapi/javax/servlet/http/HttpServlet.html)
- [ServletContext documentation](https://tomcat.apache.org/tomcat-7.0-doc/servletapi/javax/servlet/ServletContext.html) and [StackOverFlow](https://stackoverflow.com/questions/32775599/how-would-i-obtain-sessionfactory-from-the-servletcontext-in-the-dao) while trying to find how I'd keep using the same `SessionFactory`. They didn't give me the solution, but did confirm that storing it in `ServletContext` would be a problem. (I did find the video for the exercise, which showed me how it should be properly done.)

10/2

I'm getting closer to being caught up. I had to update JUnit for my project to support ordering my tests, as some tests were dependent on others' changes to the database (***Edit from October 4th***: Do ***not*** try this in your own project. It's not a good practice). I still need to figure out ID generation, but I'm pretty much done otherwise.

Resources:
- The course website, YouTube channel,and Slack
- Hibernate docs
  - [Session](https://docs.jboss.org/hibernate/orm/3.2/api/org/hibernate/Session.html)
  - [Query](https://docs.jboss.org/hibernate/orm/3.2/api/org/hibernate/Query.html)
  - [SessionFactory](https://docs.jboss.org/hibernate/orm/3.5/javadocs/org/hibernate/SessionFactory.html)
  - [Transaction](https://docs.jboss.org/hibernate/orm/3.2/api/org/hibernate/Transaction.html)
  - [Main page](https://hibernate.org/orm/documentation/5.4/)
- [Tutorialspoint Hibernate tutorial](https://www.tutorialspoint.com/hibernate/index.htm)
- [Guide on code coverage for IntelliJ](https://www.jetbrains.com/help/idea/code-coverage.html#fe1f1331)
- [Ordering JUnit tests](https://www.codejava.net/testing/junit-tests-order)
- [Maven's repository site](https://mvnrepository.com/) to find versions of JUnit to update to, so I have support for ordering the tests with annotations.

### Sixth Week

10/3 & 10/4

With use of some references, I got id generation working as I believe it should. References used particularly for this issue today include:
- [Changing the generator type in the mapping file](https://stackoverflow.com/questions/51901344/hibernate-save-always-returns-0)
- The `id` column of Week 2's 'sample' table

And during class, it was pointed out to me how much time I was *losing* trying to *save* time. I'll make a bigger effort to consume the class material from now on.

Other references from this time:
- The course website, YouTube channel, and Slack
- [Using apostrophes in MySQL](https://www.tutorialspoint.com/how-to-escape-apostrophe-in-mysql) to refresh my memory
- [ClassLoader](https://docs.oracle.com/javase/8/docs/api/java/lang/ClassLoader.html) and [FileReader](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/FileReader.html) in writing temporary cod to diagnose why my SQL file wasn't being read
- Code from [the demo](https://github.com/mad-ent-java-f22/user-display-demo-code) to find out I shouldn't be using a slash in that file name

10/5 through 10/8 (roughly speaking)

- Tutorialspoint [One to Many](https://www.tutorialspoint.com/hibernate/hibernate_one_to_many_mapping.htm) and [Many to One](https://www.tutorialspoint.com/hibernate/hibernate_many_to_one_mapping.htm)
- Hibernate Docs on JBoss
  - [OneToMany](https://docs.jboss.org/hibernate/jpa/2.1/api/javax/persistence/OneToMany.html) annotation
- Realizing `FetchType.LAZY` was a bad idea
  - On StackOverflow: [This](https://stackoverflow.com/questions/22821695/how-to-fix-hibernate-lazyinitializationexception-failed-to-lazily-initialize-a) and [this](https://stackoverflow.com/questions/72181249/how-to-fix-org-hibernate-lazyinitializationexception-failed-to-lazily-initializ)
  - Slack

### Seventh week

10/9 through 10/12

I figured out that mapping with both annotations and xml is redundant, via:
- [Not needing `*.hbm.xml` files if using annotations](https://stackoverflow.com/questions/25445627/if-we-are-using-annotation-based-hibernate-then-do-we-require-hbm-xml#:~:text=If%20you%27re%20referring%20to,to%20Hibernate%20XML%20Mapping%20files.)
- [Example annotations](https://mkyong.com/hibernate/hibernate-one-to-many-relationship-example-annotation/) and [JoinColumn documentation](https://docs.jboss.org/hibernate/jpa/2.1/api/javax/persistence/JoinColumn.html) to get the `user` property mapped to `user_id` in the database
- The class website, YouTube, and Slack

I'm still figuring out how to enable EAGER fetching. I must be missing something.

10/13 through 10/15

***Yes!*** I figured out why the `LazyInitializationException` was happening. I had redundant mappings through XML that weren't explicitly set to `EAGER`, and setting mapping to come from the existing annotations solved that problem. This was quite a learning experience, teaching me to pay more attention to the material.

I also made a generic dao, based partially on the one in one of the week's YouTube  videos.

I used these resources in the past few days:
- [JUnit assert](https://junit.org/junit4/javadoc/4.8/org/junit/Assert.html)
- Hibernate docs
  - [SQLGrammarException](https://docs.jboss.org/hibernate/orm/3.2/api/org/hibernate/exception/SQLGrammarException.html). I know I used this but I forget what for.
  - [Path](https://docs.jboss.org/hibernate/jpa/2.2/api/javax/persistence/criteria/Path.html#get-java.lang.String-), mostly looking at `get` method
  - [Session](https://docs.jboss.org/hibernate/orm/5.2/javadocs/org/hibernate/Session.html)
- Oracle JavaDocs
  - [Generic types](https://docs.oracle.com/javase/tutorial/java/generics/types.html)
  - [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html) to get the simple name of a class (though I believe I've since removed the DAO class that used it)
  - [List](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/List.html)
- The course website, YouTube channel, and Slack

### Eighth Week

10/16

I finished work for Week 6 and Week 7 today! I really just used the resources provided by the class today. It was great to work with AWS again!

10/17

I'm spending today doing some final touches to my project before week 8 starts. I'm preparing for Checkpoint 2, added a new property to `SharedMedia`, updated my SQL files, and generated an ERD.

I still plan to catch up on previous feedback, and begin work on Week 8!

10/20

I worked on Exercise 8 today. I got to learn about using web services with Java, and some quirks that can sometimes come with either the API I was using, or RoboPOJO generator's generated classes.
Resources used:
- I used the [Star Trek API](http://stapi.co/) and its documentation
- Oracle Docs
  - [Integer](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Integer.html)
  - [Testnstance Lifecycle](https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/TestInstance.Lifecycle.html)
  - [WebTarget](https://docs.oracle.com/javaee/7/api/javax/ws/rs/client/WebTarget.html) as part of problem-solving
  - [SyncInvoker](https://docs.oracle.com/javaee/7/api/javax/ws/rs/client/SyncInvoker.html) as part of problem-solving
  - [Client](https://docs.oracle.com/javaee/7/api/javax/ws/rs/client/Client.html) as part of problem-solving
- [Mozilla's docs on HTTP 406 code](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/406) as part of problem-solving

10/21 through 10/23

I've been working toward Checkpoint 3, and thus working on the project. This includes adding more pages, and implementing Cognito.

I used these resources:
- AWS documentation
  - [User Pool attributes](https://docs.aws.amazon.com/cognito/latest/developerguide/user-pool-settings-attributes.html)
  - Trying to figure out what services I was getting charged for
    - [Check for Active Resources](https://aws.amazon.com/premiumsupport/knowledge-center/check-for-active-resources/)
- Tutorialspoint
  - [JSTL 'set' tag](https://www.tutorialspoint.com/jsp/jstl_core_set_tag.htm)
  - [Standard Tags](https://www.tutorialspoint.com/jsp/jsp_standard_tag_library.htm) when trying to find an alternative to `if`/`else`, though I went with ore of a `switch` alternative
  - [Choose](https://www.tutorialspoint.com/jsp/jstl_core_choose_tag.htm)
- [Session tracking](https://www.javatpoint.com/http-session-in-session-tracking)
- Bootstrap [Colored links](https://getbootstrap.com/docs/5.0/helpers/colored-links/)
- [This](https://stackoverflow.com/questions/2523262/how-to-serve-static-content-from-tomcat) and [also this](https://stackoverflow.com/questions/2521606/spring-mvc-absolute-url-problem/2521611#2521611) for figuring out static content in TomCat
- The course website, YouTube, and Slack

### Ninth Week

10/25

Today I implemented sessions for logins, including adding new fields to soon use in the database. I also added controllers for the 'home' and 'error' pages to make use of sessions, and used JSTL to make some links on my pages work.

References used:
- [Max length of a Cognito username](https://docs.aws.amazon.com/cognito-user-identity-pools/latest/APIReference/API_AdminCreateUser.html)
- What I'm hoping is a consistent [length of Discord's user IDs](https://discord.com/developers/docs/resources/user). I couldn't find a specified length through a search, but the ID presented is 11 characters.
- [HTTP Session tracking](https://www.javatpoint.com/http-session-in-session-tracking), which I shared in Slack
- Java Documentation:
  - [HttpSession](https://docs.oracle.com/javaee/7/api/javax/servlet/http/HttpSession.html)
  - [HttpServletRequest](https://docs.oracle.com/javaee/6/api/javax/servlet/http/HttpServletRequest.html)
  - [String](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html) when looking for `substring` syntax, and other String-manipulation methods that I don't see (I can work without them as far as I can tell)
- [JSTL `url` tag](https://www.tutorialspoint.com/jsp/jstl_core_url_tag.htm)
- The course website, YouTube, and Slack

10/26 through 10/29

I've been working on implementing my database with my application

I used:
- W3Schools
  - [MySQL Unique](https://www.w3schools.com/mysql/mysql_unique.asp)
  - [HTML form elements](https://www.w3schools.com/html/html_form_elements.asp) when looking for the name of the `fieldset` element.
  - [HTML Select](https://www.w3schools.com/tags/tag_select.asp)
- Oracle JavaDocs
  - [HttpServletResponse](https://docs.oracle.com/javaee/6/api/javax/servlet/http/HttpServletResponse.html)
  - [String](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html)
  - [HttpServlet](https://docs.oracle.com/javaee/7/api/javax/servlet/http/HttpServlet.html)
  - [`switch` statement](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html)
- StackOverflow
  - [`HttpServletResponse.sendRedirect()` usually causes a GET request](https://stackoverflow.com/questions/30292386/httpservletresponse-sendredirect-change-method-type), which is what I was hoping for
  - [HTML forms can't make `PUT` calls](https://stackoverflow.com/questions/8054165/using-put-method-in-html-form), which I was hoping to do
- [Getting from data from a `Post` request](https://www.tutorialspoint.com/servlets/servlets-form-data.htm)
- Bootstrap
  - [Tables](https://getbootstrap.com/docs/5.0/content/tables/)
  - [Forms](https://getbootstrap.com/docs/5.0/forms/overview/)
  - [Background Colors](https://getbootstrap.com/docs/5.0/utilities/background/)
  - [Borders](https://getbootstrap.com/docs/5.0/utilities/borders/)
  - [Flex: Alig Items](https://getbootstrap.com/docs/5.0/utilities/flex/#align-items)

### Tenth week

10/30 through 11/1

I've been in the process of wrapping Checkpoint 3 up. I've also found I've been handling checking for null incorrectly, as the usual methods weren't working because I thought I had Sessions returning null values, when the sessions themselves were what were null.

Resources:
- W3Schools
  - [HTML Form Elements](https://www.w3schools.com/html/html_form_elements.asp), though I cant remember what I used this for
  - [HTML Option `selected` attribute](https://www.w3schools.com/tags/att_option_selected.asp)
- Tutorialspoint
  - [JSTL If](https://www.tutorialspoint.com/jsp/jstl_core_if_tag.htm)
  - [JSTL Choose](https://www.tutorialspoint.com/jsp/jstl_core_choose_tag.htm)
- Java Documentation
  - [HttpSession](https://docs.oracle.com/javaee/6/api/javax/servlet/http/HttpSession.html)
  - [HttpServlet](https://docs.oracle.com/javaee/6/api/javax/servlet/http/HttpServletRequest.html)
- Finding [why I was getting `NullPointerException` so often](https://stackoverflow.com/questions/32666972/getting-data-from-session-attribute-returns-null-pointer)
- [Error Pages in web.xml](https://www.codejava.net/java-ee/servlet/how-to-handle-error-in-web-xml-for-java-web-applications)

11/2

- [Javatpoint Restful annotations example](https://www.javatpoint.com/jax-rs-annotations-example)
- [JAX-RS tutorials](https://mkyong.com/tutorials/jax-rs-tutorials/)

### Eleventh week

11/3 through 11/13
See journal for Team Project, and Professional Development Activity presentation.

### Twelfth week

Sometime in Week 12

I worked ahead and completed week 13, without much issue. It was great learning another way for applications to communicate.

### Thirteenth week

11/21 through 11/26

I've had to do some re-adjustment of scope recently

- I set my app up at https://console.cloud.google.com/
- I started making a DAO for YouTube from an example [here](https://developers.google.com/youtube/v3/code_samples/code_snippets?apix=true)
- [JavaDocs](https://developers.google.com/resources/api-libraries/documentation/youtube/v3/java/latest/) for the library for YouTube
- https://developers.google.com/youtube/v3/quickstart/java
- Maven
  - https://mvnrepository.com/artifact/com.google.apis/google-api-services-youtube
  - https://mvnrepository.com/artifact/com.google.api-client/google-api-client

### Fourteenth Week

11/28
- [YouTube Video documentation](https://developers.google.com/resources/api-libraries/documentation/youtube/v3/java/latest/com/google/api/services/youtube/YouTube.Videos.html)
- Maven repositories
  - https://mvnrepository.com/artifact/com.google.oauth-client/google-oauth-client-java6/1.34.1
  - https://mvnrepository.com/artifact/com.google.oauth-client/google-oauth-client-jetty/1.34.1

11/29
It took some time, but I found how to use the API key with the YouTube Data API library. Seeing [Videos.List.setKey](https://developers.google.com/resources/api-libraries/documentation/youtube/v3/java/latest/com/google/api/services/youtube/YouTube.Videos.List.html) was very helpful, even if I had to do quite a bit of looking to find which clas had the method.
I used:
- The link above, as well as [this StackOverflow thread](https://stackoverflow.com/questions/26117184/how-to-put-api-key-into-youtube-builder-in-youtubes-android-api)
- Course website, YouTube channel, and Slack
- Seeing I could pass null for my credentials on [`Youtube.Builder`](https://developers.google.com/resources/api-libraries/documentation/youtube/v3/java/latest/com/google/api/services/youtube/YouTube.Builder.html)

### Fifteenth Week

11/30 through 12/4
- [YouTube embedding with iFrames](https://developers.google.com/youtube/player_parameters)
- [Sending Errors](https://docs.oracle.com/javaee/6/api/javax/servlet/http/HttpServletResponse.html)
- [Refresh on `Integer.parseInt`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Integer.html)
- [HTTP Error Codes](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#server_error_responses)

12/5
- [W3Schools: Textarea](https://www.w3schools.com/tags/tag_textarea.asp)
- [Converting sets to lists](https://www.geeksforgeeks.org/set-list-java/) (I used Method 2)
- The big one?!? [Accessing session from JSPs](https://www.javatips.net/blog/reading-session-attributes-using-jstl)
- The course meeting, Slack, and website

12/6
- [Quota Calculator](https://developers.google.com/youtube/v3/determine_quota_cost)
- [HTML tables](https://www.w3schools.com/html/html_tables.asp)
- [JSTL URLs](https://www.tutorialspoint.com/jsp/jstl_core_url_tag.htm)
- YouTube Data API
  - [VideoSnippet](https://developers.google.com/resources/api-libraries/documentation/youtube/v3/java/latest/)
  - [ThumbnailDetails](https://developers.google.com/resources/api-libraries/documentation/youtube/v3/java/latest/com/google/api/services/youtube/model/ThumbnailDetails.html)
  - [Thumbnail](https://developers.google.com/resources/api-libraries/documentation/youtube/v3/java/latest/com/google/api/services/youtube/model/Thumbnail.html)
- [HTTP Error codes](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#client_error_responses)

12/7 through 12/10
- [JSTL if](https://www.tutorialspoint.com/jsp/jstl_core_if_tag.htm)
- [JSTL choose](https://www.tutorialspoint.com/jsp/jstl_core_choose_tag.htm)
- Refresher that [JSPs still need two `=`s when comparing](http://www.java2s.com/Questions_And_Answers/JSP-Servlet/JSTL/compare.htm)
- [HTTP status codes](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status)
- [Check for not null when checking for checkboxes](https://coderanch.com/t/358902/java/checkbox)
- [`HttpSession` documentation](https://docs.oracle.com/javaee/7/api/javax/servlet/http/HttpSession.html)

### Sixteenth Week

12/11
- [jQuery form validation](https://www.geeksforgeeks.org/form-validation-using-jquery/) for the posting and edit forms
  - I wanted to have a decent understanding of the base for my alteration, so I looked up the [`keyup` function](https://www.w3schools.com/jquery/event_keyup.asp)
  - My form wasn't submitting, so I looked up [the `submit` function](https://api.jquery.com/submit/#submit) to learn why. The example has `click` rather than `submit`
- [This StackOverflow thread](https://stackoverflow.com/questions/25080148/error-no-suitable-driver-found-for-database-on-aws-rds) wasn't exactly necessary, but did help me realize I forgot `jdbc:mysql://` at the start of my connection in Hibernate's configuration.
- The course website, Slack, and YouTube channel