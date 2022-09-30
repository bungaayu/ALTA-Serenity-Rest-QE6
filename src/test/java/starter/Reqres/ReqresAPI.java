package starter.Reqres;

import io.restassured.http.ContentType;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class ReqresAPI {
    public static String URL = "https://reqres.in";
    public static final String GET_LIST_USERS = URL+"/api/users?page={page}";
    public static final String GET_LIST_USERS_NOPARAM = URL + "/api/users";
    public static final String GET_SINGLE_USER = URL + "/api/users/{data.id}";
    public static final String GET_SINGLE_USERS_NOPARAM = URL + "/api/users";
    public static final String POST_CREATE_NEW_USER = URL+"/api/users";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE = DIR+"/src/test/resources/features/JSON";
    public static final String PUT_UPDATE_USER = URL + "/api/users/{id}";
    public static final String PATCH_UPDATE_USER = URL + "/api/users/{id}";
    public static final String DELETE_USER = URL + "/api/users/{id}";
    public static final String DELETE_USER_NOPARAM = URL + "/api/users/";
    public static final String GET_LIST_RESOURCE_NOPATH = URL + "/api/unknown";
    public static final String GET_LIST_RESOURCE = URL +"/api/unknown?page={page}";
    public static final String GET_SINGLE_RESOURCE = URL + "/api/unknown/{data.id}";
    public static final String POST_REGISTER = URL +"/api/register";
    public static final String POST_LOGIN = URL + "/api/login";

    //GET LIST USERS
    @Step("Get list users")
    public void getListUsers(int page){
        SerenityRest.given().pathParam("page", page);
    }
    @Step("Get list users with invalid string parameter")
    public void getListUsersWithInvalidStringParameter(String page){
        SerenityRest.given().pathParam("page",page);
    }
    @Step("Get list users with invalid spec char parameter")
    public void getListUserWithInvalidSpecCharParameter(String page){
        SerenityRest.given().pathParam("page", page);
    }
    @Step("Get list users without parameter")
    public void getListUsersWithoutParameter(){
        SerenityRest.given();
    }

    //POST CREATE USERS
    @Step("Post create new user")
    public void postCreateNewUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    //GET SINGLE USER
    @Step("Get single user int")
    public void getSingleUserInt(int id){
        SerenityRest.given().pathParam("data.id",id);
    }
    @Step("Get single user with invalid string id")
    public void getSingleUserWithInvalidStringId(String id){
        SerenityRest.given().pathParam("data.id",id);
    }
    @Step("Get single user with invalid spec char id")
    public void getSingleUserWithInvalidSpecCharId(String id){
        SerenityRest.given().pathParam("data.id",id);
    }
    @Step("Get single user without parameter")
    public void getSingleUserWithoutParameter(){
        SerenityRest.given();
    }

    //PUT UPDATE USER
    @Step("Put update user")
    public void putUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    //PATCH UPDATE USER
    @Step("Patch update user")
    public void patchUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    ///DELETE USER
    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Delete user with invalid string id")
    public void deleteUserWithInvalidStringId(String id){
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Delete user with invalid spec char id")
    public void deleteUserWithInvalidSpecCharId(String id){
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Delete user without parameter id")
    public void deleteUserWithoutParameterId(){
        SerenityRest.given();
    }

    //GET LIST RESOURCE
    @Step("Get list resource without path")
    public void getListResourceWithoutPath(){
        SerenityRest.given();
    }
    @Step("Get list resource")
    public void getListResource(int page){
        SerenityRest.given().pathParam("page", page);
    }
    @Step("Get list resource with invalid param")
    public void getListResourceWithInvalidParam(String page){
        SerenityRest.given().pathParam("page", page);
    }

    //GET SINGLE RESOURCE
    @Step("Get single resource with id")
    public void getSingleResourceWithId(int id){
        SerenityRest.given().pathParam("data.id",id);
    }
    @Step("Get single resource with invalid id")
    public void getSingleResourceWithInvalidId(String id){
        SerenityRest.given().pathParam("data.id",id);
    }

    //POST REGISTER
    @Step("Post register new user")
    public void postRegisterNewUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    //POST LOGIN
    @Step("Post login")
    public void postLogin(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post login with unregistered user")
    public void postLoginWithUnregisteredUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post login with incomplete data")
    public void postLoginWithIncompleteData(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
