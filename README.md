#Autrui

**Purpose**

With the advent of technology in the daily lives of people in the past decade, it has been through many forms of uses – from being a luxury to utility to now a means of entertainment. We see that with though this transition has bought greater connectivity and access to information, it has also lost compassion somewhere down the road. The whole world of the social network seems cold and lacks benevolence. We have decided to carry the idea of bridging this gap, by creating a mobile application that aims at bridging this gap. 

The app is inspired by the Pay It Forward Movement. The idea is to respond to a person's kindness to oneself by being kind to someone else. Our app focuses on providing a social platform where users will be able to connect through these kind deeds, and see the impact of their deed.


##Current Plan##

- [x] Project Charter
- [x] Code Repository Setup, Project Name, Product Backlog 
- [x] Design Document
- [x] Iteration ONE Sprint Planning Document
- [x] Iteration ONE Sprint Review Meeting 
- [x] Iteration ONE Sprint Retrospective 
- [x] Iteration TWO Sprint Planning Document 
- [x] Iteration TWO Sprint Review Meeting 
- [x] Iteration TWO Sprint Retrospective 
- [x] Iteration THREE Sprint Planning Document 
- [x] Iteration THREE Sprint Review Meeting (On Thursday, April 24th - Second Presentation) - Good Job Guys
- [x] Iteration THREE Sprint Retrospective
- [ ] Teaming Experience Reflection Paper Dropbox closes (On Wednesday, May 7th)


##Instructions##

Once the project has been pulled from the master branch, you need to do the following to compile and run the project:

- Remove the Splash project from your workspace(Delete it, but make sure to not delete the files from your computer)
- Import the autrui folder which is inside Main App_v2.0 folder and copy the contents to your workspace (make sure the workspace is different from the autrui-repo)

####Facebook Sdk####

- Download the facebook sdk from - https://github.com/facebook/facebook-android-sdk. (There is a option to download it as zip, please do that)
- Then unzip it and import the facebook folder by going into (facebook-android-sdk-master/facebook) also copy the contents into your workspace (This can be done by right clicking on the Eclipse Explorer and choosing Import)
- Clean your project, there can be errors. (Note:The app works perfectly on my kindle, so you shouldn't have problems, Fragments looks good :) ) 

#####Likely causes for Errors#####

- Next if all of the errors dont do away, right click on autrui (or the name of the folder which has our app) and then click on properties
- Then click on 'Android' on your left hand side and see if the library part of the window is empty (this will be near the bottom of the window).
- If it is empty then add Facebook (If you have imported it correctly it should be called FacebookSDK) as a library and click on Apply, don't click on the Check box which says 'Is Library', and then click on Ok
- You might also need to add External Jars for Parse and Android.support.v4.  This can be done by going into properties, Java Build Path, Libraries(Add external JARs, the jars are inside of the libs folder of autrui), Order and Export (Check the JAR files)
- Clean your project
- Run as done so previously

###Note###

It can happen that you still might get errors and that is because you don't have the required SDK versions. I recommend to install API 8, 10, 14. If it still doesn't work then also install API 17,18. 

BUT I HAVE NOW MADE THE MINIMUM SDK 15 AND MAX 19, SO YOU SHOULDN'T HAVE TO DOWNALOAD THE ABOVE SDKs.

*Note: I have removed ALL the facebook folder and added facebook-android-sdk-master. 

##Links##

Wiki Page URL - https://github.com/mihirjham/autrui-repo/wiki
