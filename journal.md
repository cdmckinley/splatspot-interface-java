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