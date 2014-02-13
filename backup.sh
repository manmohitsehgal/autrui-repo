#!/bin/bash

#	Author: Ankit Kapur	Class: CS307
#	backup.sh Shell Script
#	This script will be used to backup the main repository in order to twart accidental removals or deletions.
#	The repository will be backed up 3 times a day and the script will maintain a backup for the past 30 days.
#	The backup will go to a backup repository on GitHub.
#	Backup Repository URL: https://github.com/ankitk/autrui-backup

#	variables
DAY=1
FILEDATE="$(date +%d)"
MAX=30
BACKUP=1
INTERVAL=3600
#	end variables

#	@func	init
init()
{
	mkdir "DAY $DAY"
	cd "DAY $DAY"
	git init
	git remote add origin git@github.com:ankitk/autrui-backup.git
	git pull origin master	
	cd ..
}
#	endFunc

#	@func	gitClone
gitClone()
{
	git clone git@github.com:mihirjham/autrui-repo.git
}
#	endFunc

#	@func gitPush
gitPush()
{
	cd ..	
	git add "$BACKUP"
	echo "git add $BACKUP" 
	git commit -m "Routine Backup Addition" 
	git push origin master 
}
#	endFunc

init
while [ 1 ]; do
	CURRENTDATE="$(date +%d)"
#	If date has changed, update date and create folder for new date
	if [ $CURRENTDATE != $FILEDATE ]; then
		FILEDATE=CURRENTDATE
		BACKUP=1
		DAY=$((DAY + 1))
		mkdir "DAY $DAY"
		cd "DAY $DAY"
		git init
		git remote add origin git@github.com:ankitk/autrui-backup.git	
		git pull origin master	
		cd ..	
	fi	

#	Create backup directory and git clone. Then update BACKUP variable 
	mkdir "DAY $DAY"/"$BACKUP"
	cd "DAY $DAY"/"$BACKUP"/
	gitClone
	gitPush
	cd ..	
	BACKUP=$((BACKUP + 1))
	
#	Maintain a backup of past 30 days only
	if [ $DAY -gt $MAX ]; then
		MIN=$((DAY-MAX))
		rm -r "DAY $MIN"
	fi
	MIN=$((DAY-MAX))
	echo $MIN	
	sleep $INTERVAL
done	
