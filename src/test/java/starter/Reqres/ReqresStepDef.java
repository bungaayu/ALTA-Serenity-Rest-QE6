package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;


public class ReqresStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //Scenario 1
    @Given("get list user with parameter page {int}")
    public void getListUserWithParameterPage(int page) {
        reqresAPI.getListUsers(page);
    }
    @When("send request get list user")
    public void sendRequestGetListUser() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
    }
    @Then("should return {int} ok")
    public void shouldReturnOk(int ok) {
//        restAssuredThat(response -> response.statusCode(ok));
        SerenityRest.then().statusCode(ok);
    }
    @And("response body page should be {int}")
    public void responseBodyPageShouldBe(int page) {
        SerenityRest.then().body(ReqresResponses.PAGE,equalTo(page));
    }
    @And("get list user json schema validator")
    public void getListUserJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/JsonSchema/GetListUserJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario 1.2
    @Given("get list user with invalid string parameter {string}")
    public void getListUserWithInvalidStringParameter(String page) {
        reqresAPI.getListUsersWithInvalidStringParameter(page);
    }
    @Then("should return {int} not found")
    public void shouldReturnNotFound(int notfound) {
        SerenityRest.then().statusCode(notfound);
    }

    //Scenario 1.3
    @Given("get list user with invalid special char parameter {string}")
    public void getListUserWithInvalidSpecialCharParameter(String page) {
        reqresAPI.getListUserWithInvalidSpecCharParameter(page);
    }

    //Scenario 1.4
    @Given("get list user without parameter")
    public void getListUserWithoutParameter() {
        reqresAPI.getListUsersWithoutParameter();
    }
    @When("send request get list user without parameter")
    public void sendRequestGetListUserWithoutParameter() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS_NOPARAM);
    }

    //Scenario 2.1
    @Given("post create new user")
    public void postCreateNewUser() {
        File json = new File(ReqresAPI.JSON_FILE+"/RequestBody/PostCreateNewUser.json");
        reqresAPI.postCreateNewUser(json);
    }
    @When("send request post create new user")
    public void sendRequestPostCreateNewUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_NEW_USER);
    }
    @Then("should return {int} created")
    public void shouldReturnCreated(int created) {
        SerenityRest.then().statusCode(created);
    }
    @And("response body should contain name {string} and job {string}")
    public void responseBodyShouldContainNameAndJob(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job));
    }
    @And("post create new user json schema validator")
    public void postCreateNewUserJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/JsonSchema/PostCreateNewUserJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario 2.2
    @Given("post create new user with incomplete json")
    public void postCreateNewUserWithIncompleteJson() {
        File json = new File(ReqresAPI.JSON_FILE+"/RequestBody/PostCreateNewUserInv.json");
        reqresAPI.postCreateNewUser(json);
    }
    @Then("should return {int} bad request")
    public void shouldReturnBadRequest(int badreq) {
        SerenityRest.then().statusCode(badreq);
    }

    //Scenario 3.1
    @Given("get single user with id {int}")
    public void getSingleUserWithId(int id) {
        reqresAPI.getSingleUserInt(id);
    }
    @When("send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }
    @And("response body id should be {int}")
    public void responseBodyIdShouldBe(int id) {
        SerenityRest.then().body(ReqresResponses.ID,equalTo(id));
    }

    //Scenario 3.3
    @Given("get single user with invalid string id {string}")
    public void getSingleUserWithInvalidStringId(String id) {
        reqresAPI.getSingleUserWithInvalidStringId(id);
    }

    //Scenario 3.4
    @Given("get single user with invalid special char id {string}")
    public void getSingleUserWithInvalidSpecialCharId(String id) {
        reqresAPI.getSingleUserWithInvalidSpecCharId(id);
    }

    //Scenario 3.5
    @Given("get single user without parameter")
    public void getSingleUserWithoutParameter() {
        reqresAPI.getSingleUserWithoutParameter();
    }
    @When("send request get single user without parameter")
    public void sendRequestGetSingleUserWithoutParameter() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USERS_NOPARAM);
    }

    //Scenario 4.1
    @Given("put update user with id {int}")
    public void putUpdateUserWithId(int id) {
        File json = new File(ReqresAPI.JSON_FILE+"/RequestBody/PutUpdateUser.json");
        reqresAPI.putUpdateUser(id,json);
    }
    @When("send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }
    @And("put update user json schema validator")
    public void putUpdateUserJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/JsonSchema/PutUpdateUserJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    //Scenario 4.2
    @Given("put update user incomplete json with id {int}")
    public void putUpdateUserIncompleteJsonWithIdId(int id) {
        File json = new File(ReqresAPI.JSON_FILE+"/RequestBody/PutUpdateUserIncomplete.json");
        reqresAPI.putUpdateUser(id,json);
    }

    //Scenario 5.1
    @Given("patch update user with id {int}")
    public void patchUpdateUserWithId(int id) {
        File json = new File(ReqresAPI.JSON_FILE+"/RequestBody/PatchUpdateUser.json");
        reqresAPI.patchUpdateUser(id,json);
    }
    @When("send request patch update user")
    public void sendRequestPatchUpdateUser() {
        SerenityRest.when().patch(ReqresAPI.PATCH_UPDATE_USER);
    }
    @And("response body should contain name {string}")
    public void responseBodyShouldContainName(String name) {
        SerenityRest.then()
                .body(ReqresResponses.NAME,equalTo(name));
    }

    //Scenario 5.2
    @Given("patch update complete user with id {int}")
    public void patchUpdateCompleteUserWithId(int id) {
        File json = new File(ReqresAPI.JSON_FILE+"/RequestBody/PatchUpdateUserCompl.json");
        reqresAPI.patchUpdateUser(id,json);
    }

    //Scenario 6.1
    @Given("delete user with valid id {int}")
    public void deleteUserWithValidId(int id) {
        reqresAPI.deleteUser(id);
    }
    @When("send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }
    @Then("should return {int} no content")
    public void shouldReturnNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }

    //Scenario 6.2
    @Given("delete user with invalid string id {string}")
    public void deleteUserWithInvalidStringId(String id) {
        reqresAPI.deleteUserWithInvalidStringId(id);
    }

    //Scneario 6.3
    @Given("delete user with invalid special char id {string}")
    public void deleteUserWithInvalidSpecialCharId(String id) {
        reqresAPI.deleteUserWithInvalidSpecCharId(id);
    }

    //Scenario 6.4
    @Given("delete user without parameter id")
    public void deleteUserWithoutParameterId() {
        reqresAPI.deleteUserWithoutParameterId();
    }
    @When("send request delete user without parameter id")
    public void sendRequestDeleteUserWithoutParameterId() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER_NOPARAM);
    }

    //Scenario 7.1
    @Given("get list resource without path")
    public void getListResourceWithoutPath() {
        reqresAPI.getListResourceWithoutPath();
    }
    @When("send request get list resource without path")
    public void sendRequestGetListResourceWithoutPath() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_RESOURCE_NOPATH);
    }

    //Scenario 7.2
    @Given("get list resource with parameter page {int}")
    public void getListResourceWithParameterPage(int page) {
        reqresAPI.getListResource(page);
    }
    @When("send request get list resource")
    public void sendRequestGetListResourceWithParameter() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_RESOURCE);
    }

    //Scenario 7.3
    @Given("get list resource with invalid parameter page {string}")
    public void getListResourceWithInvalidParameterPage(String page) {
        reqresAPI.getListResourceWithInvalidParam(page);
    }

    //Scenario 8.1
    @Given("get single resource with id {int}")
    public void getSingleResourceWithId(int id) {
        reqresAPI.getSingleResourceWithId(id);
    }
    @When("send request get single resource")
    public void sendRequestGetSingleResource() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_RESOURCE);
    }

    //Scenario 8.3
    @Given("get single resource with invalid id {string}")
    public void getSingleResourceWithInvalidId(String id) {
        reqresAPI.getSingleResourceWithInvalidId(id);
    }

    //Scenario 9.1
    @Given("post register new user")
    public void postRegisterNewUser() {
        File json = new File(ReqresAPI.JSON_FILE+"/RequestBody/PostRegister.json");
        reqresAPI.postRegisterNewUser(json);
    }
    @When("send request post register new user")
    public void sendRequestPostRegisterNewUser() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER);
    }

    //Scenario 9.2
    @Given("post register new user invalid json")
    public void postRegisterNewUserInvalidJson() {
        File json = new File(ReqresAPI.JSON_FILE+"/RequestBody/PostRegisterInvalid.json");
        reqresAPI.postRegisterNewUser(json);
    }

    //Scenario 10.1
    @Given("post login with valid json")
    public void postLoginWithValidJson() {
        File json = new File(ReqresAPI.JSON_FILE+"/RequestBody/PostLogin.json");
        reqresAPI.postLogin(json);
    }
    @When("send request post login")
    public void sendRequestPostLogin() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN);
    }

    //Scenario 10.2
    @Given("post login with unregistered user")
    public void postLoginWithUnregisteredUser() {
        File json = new File(ReqresAPI.JSON_FILE+"/RequestBody/PostLoginUnregis.json");
        reqresAPI.postLoginWithUnregisteredUser(json);
    }

    //Scenario 10.3
    @Given("post login with incomplete json")
    public void postLoginWithIncompleteJson() {
        File json = new File(ReqresAPI.JSON_FILE+"/RequestBody/PostLoginIncomplete.json");
        reqresAPI.postLoginWithIncompleteData(json);
    }


//Thread.sleep(3000);

}
