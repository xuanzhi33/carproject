# Car Project

## Project Introduction: 

**Project Tutor:** Fazl Ullah Khan 
**Duration:** June 19, 2024 - September 2024

**Brief introduction:** This project addresses the issues of frequent lane changes, sudden braking, and potential fatigue driving by online-hired drivers. The aim is to design an app to detect and evaluate driver behavior. The project is divided into two branches:

**A.** After collecting data through both software and hardware, the data is processed using Machine Learning (ML) to detect whether the driver is making sudden lane changes or braking.      

Software: By developing simple-function apps for both Android and iOS or a webview (suggested by student Anzhi Xu, to be discussed with the professor in the group meeting), we will utilize the built-in sensors of mobile phones to collect data.

Hardware: We will seek more suitable sensors to detect issues related to sudden lane changes and braking by drivers.

**B.** Detect whether the driver is fatigued by observing the driver's facial features, eye signals, and head movements. This branch involves Artificial Intelligence (AI), and the feasibility and implementation methods (i.e., innovative points) will be discussed in the group meeting.

## Links

- [Sensor Data Collection](https://gh.xuanzhi33.cn/carproject/sensor.html)
- [Data Download](https://gh.xuanzhi33.cn/carproject/data.html)
- [Android APK Download](https://gh.xuanzhi33.cn/carproject/assets/app-release.apk)

## Project Structure Overview

This repository is organized into several directories, each serving a specific purpose within the project:

### docs/

The `docs/` directory contains frontend pages and documents that are intended to be deployed on the server. These pages likely serve as the user interface or documentation for the project.

### server/

The `server/` directory hosts the backend code responsible for data collection. This includes scripts, APIs, or services that gather and process data from various sources.

### data/

In the `data/` directory, you will find an SQLite3 database used for storing the collected data. This database likely stores structured data that has been gathered by the server-side components.

### gd/

The `gd/` directory houses machine learning algorithms and related code. This includes models, training scripts, or utilities used for analyzing or predicting data based on machine learning techniques.

### Android-app/

The `Android-app/` directory contains the complete source code for an Android application associated with the project. This includes both frontend UI components and backend logic specific to the mobile platform.

