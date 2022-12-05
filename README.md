<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/bungaayu/Reqres-APITesting">
    <img src="https://avatars0.githubusercontent.com/u/19369327?s=400&v=4" alt="Logo" width="80" height="80">
  </a>

<h3 align="center">Reqres.in API Automated Testing</h3>

</div>

<!-- ABOUT THE PROJECT -->
## About The Project

![Reqres Report](https://user-images.githubusercontent.com/56777574/203685444-5d7c6252-de6e-42cc-8806-e6e12c61d0c9.png)

This is the report using Rest Assured to Automate API testing on reqres.in. Implementing gherkin syntax for the main feature.
This project is based on ***[Reqres - A freely available REST API.](https://reqres.in)***

Testing Documentation on Spreadsheet: [Documentation](https://docs.google.com/spreadsheets/d/1tGaMHlrTy36IBHknMJSJr5UhTKNk6LRatoisD0Ki7a4/edit?usp=sharing)

### Built With

* [Java 1.8](https://www.oracle.com/java/technologies/downloads/)
* [Intellij IDEA]()
* [Maven]()

<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these simple example steps.

### Installation

#### Method 1: Trough terminal (Maven Should be Installed)

1. Clone the repo
   ```sh
   git clone https://github.com/bungaayu/Reqres-APITesting.git
   ```
3. Go to project directory
   ```sh
   cd Reqres-APITesting
   ```
4. run Maven command
   ```sh
   mvn clean verify
   ```
#### Method 2: Trough Intellij IDEA

1. Create New Project
2. Select from "versioning control"
3. Paste https://github.com/bungaayu/Reqres-APITesting.git
4. Select JDK 1.8
5. Select maven
6. Click OK

<!-- FEATURE TESTED -->
## Feature Tested

1. Authorization
   * POST Login user  
3. Registration
   * POST Register New User 
4. Resources - USERS
   * POST Create New Users
   * GET List Users with page
   * GET Single Users with ID
   * PUT Update Users Attributes
   * DEL Existing Users
   * GET List Resource with page
   * GET Single Resource with ID

<!-- CONTACT -->
## Contact

Bunga Ayu Ferdiyanti - bungaayu9599@gmail.com

Project Link: [https://github.com/bungaayu/Reqres-APITesting](https://github.com/bungaayu/Reqres-APITesting)

<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

* [Alterra Academy](https://academy.alterra.id/)
* [Rest Assured](https://github.com/rest-assured/rest-assured)
* [Our Mentor - Wisnu Munawar](https://github.com/wisnuwm)

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/AnjarTiyo/RestAssured-Reqres-Automation.svg?style=for-the-badge
[contributors-url]: https://github.com/AnjarTiyo/RestAssured-Reqres-Automation/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/AnjarTiyo/RestAssured-Reqres-Automation.svg?style=for-the-badge
[forks-url]: https://github.com/AnjarTiyo/RestAssured-Reqres-Automation/network/members
[stars-shield]: https://img.shields.io/github/stars/AnjarTiyo/RestAssured-Reqres-Automation.svg?style=for-the-badge
[stars-url]: https://github.com/AnjarTiyo/RestAssured-Reqres-Automation/stargazers
[issues-shield]: https://img.shields.io/github/issues/AnjarTiyo/RestAssured-Reqres-Automation.svg?style=for-the-badge
[issues-url]: https://github.com/AnjarTiyo/RestAssured-Reqres-Automation/issues
[license-shield]: https://img.shields.io/github/license/AnjarTiyo/RestAssured-Reqres-Automation.svg?style=for-the-badge
[license-url]: https://github.com/AnjarTiyo/RestAssured-Reqres-Automation/blob/main/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/anjartiyo
[product-screenshot]: src/docs/Screenshot_2022-09-28_14_01_25.png
