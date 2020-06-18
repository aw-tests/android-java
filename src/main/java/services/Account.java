package .services;



import okhttp3.Call;
import okhttp3.HttpUrl;
import .Client;
import .enums.OrderType;

import java.io.File;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class Account extends Service {
    public Account(Client client){
        super(client);
    }

     /// Get Account
     /*
     * Get currently logged in user data as JSON object.
     */
    public Call get() {
        final String path = "/account";

        final Map<String, Object> params = Map.ofEntries(
        );



        final Map<String, String> headers = Map.ofEntries(
            entry("content-type", "application/json")
        );

        return client.call("GET", path, headers, params);
    }

     /// Create Account
     /*
     * Use this endpoint to allow a new user to register a new account in your
     * project. After the user registration completes successfully, you can use
     * the [/account/verfication](/docs/client/account#createVerification) route
     * to start verifying the user email address. To allow your new user to login
     * to his new account, you need to create a new [account
     * session](/docs/client/account#createSession).
     */
    public Call create(String email, String password, String name) {
        final String path = "/account";

        final Map<String, Object> params = Map.ofEntries(
            entry("email", email),
            entry("password", password),
            entry("name", name)
        );



        final Map<String, String> headers = Map.ofEntries(
            entry("content-type", "application/json")
        );

        return client.call("POST", path, headers, params);
    }

     /// Delete Account
     /*
     * Delete a currently logged in user account. Behind the scene, the user
     * record is not deleted but permanently blocked from any access. This is done
     * to avoid deleted accounts being overtaken by new users with the same email
     * address. Any user-related resources like documents or storage files should
     * be deleted separately.
     */
    public Call delete() {
        final String path = "/account";

        final Map<String, Object> params = Map.ofEntries(
        );



        final Map<String, String> headers = Map.ofEntries(
            entry("content-type", "application/json")
        );

        return client.call("DELETE", path, headers, params);
    }

     /// Update Account Email
     /*
     * Update currently logged in user account email address. After changing user
     * address, user confirmation status is being reset and a new confirmation
     * mail is sent. For security measures, user password is required to complete
     * this request.
     */
    public Call updateEmail(String email, String password) {
        final String path = "/account/email";

        final Map<String, Object> params = Map.ofEntries(
            entry("email", email),
            entry("password", password)
        );



        final Map<String, String> headers = Map.ofEntries(
            entry("content-type", "application/json")
        );

        return client.call("PATCH", path, headers, params);
    }

     /// Get Account Logs
     /*
     * Get currently logged in user list of latest security activity logs. Each
     * log returns user IP address, location and date and time of log.
     */
    public Call getLogs() {
        final String path = "/account/logs";

        final Map<String, Object> params = Map.ofEntries(
        );



        final Map<String, String> headers = Map.ofEntries(
            entry("content-type", "application/json")
        );

        return client.call("GET", path, headers, params);
    }

     /// Update Account Name
     /*
     * Update currently logged in user account name.
     */
    public Call updateName(String name) {
        final String path = "/account/name";

        final Map<String, Object> params = Map.ofEntries(
            entry("name", name)
        );



        final Map<String, String> headers = Map.ofEntries(
            entry("content-type", "application/json")
        );

        return client.call("PATCH", path, headers, params);
    }

     /// Update Account Password
     /*
     * Update currently logged in user password. For validation, user is required
     * to pass the password twice.
     */
    public Call updatePassword(String password, String oldPassword) {
        final String path = "/account/password";

        final Map<String, Object> params = Map.ofEntries(
            entry("password", password),
            entry("oldPassword", oldPassword)
        );



        final Map<String, String> headers = Map.ofEntries(
            entry("content-type", "application/json")
        );

        return client.call("PATCH", path, headers, params);
    }

     /// Get Account Preferences
     /*
     * Get currently logged in user preferences as a key-value object.
     */
    public Call getPrefs() {
        final String path = "/account/prefs";

        final Map<String, Object> params = Map.ofEntries(
        );



        final Map<String, String> headers = Map.ofEntries(
            entry("content-type", "application/json")
        );

        return client.call("GET", path, headers, params);
    }

     /// Update Account Preferences
     /*
     * Update currently logged in user account preferences. You can pass only the
     * specific settings you wish to update.
     */
    public Call updatePrefs(Object prefs) {
        final String path = "/account/prefs";

        final Map<String, Object> params = Map.ofEntries(
            entry("prefs", prefs)
        );



        final Map<String, String> headers = Map.ofEntries(
            entry("content-type", "application/json")
        );

        return client.call("PATCH", path, headers, params);
    }

     /// Create Password Recovery
     /*
     * Sends the user an email with a temporary secret key for password reset.
     * When the user clicks the confirmation link he is redirected back to your
     * app password reset URL with the secret key and email address values
     * attached to the URL query string. Use the query string params to submit a
     * request to the [PUT /account/recovery](/docs/client/account#updateRecovery)
     * endpoint to complete the process.
     */
    public Call createRecovery(String email, String url) {
        final String path = "/account/recovery";

        final Map<String, Object> params = Map.ofEntries(
            entry("email", email),
            entry("url", url)
        );



        final Map<String, String> headers = Map.ofEntries(
            entry("content-type", "application/json")
        );

        return client.call("POST", path, headers, params);
    }

     /// Complete Password Recovery
     /*
     * Use this endpoint to complete the user account password reset. Both the
     * **userId** and **secret** arguments will be passed as query parameters to
     * the redirect URL you have provided when sending your request to the [POST
     * /account/recovery](/docs/client/account#createRecovery) endpoint.
     * 
     * Please note that in order to avoid a [Redirect
     * Attack](https://github.com/OWASP/CheatSheetSeries/blob/master/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.md)
     * the only valid redirect URLs are the ones from domains you have set when
     * adding your platforms in the console interface.
     */
    public Call updateRecovery(String userId, String secret, String password, String passwordAgain) {
        final String path = "/account/recovery";

        final Map<String, Object> params = Map.ofEntries(
            entry("userId", userId),
            entry("secret", secret),
            entry("password", password),
            entry("passwordAgain", passwordAgain)
        );



        final Map<String, String> headers = Map.ofEntries(
            entry("content-type", "application/json")
        );

        return client.call("PUT", path, headers, params);
    }

     /// Get Account Sessions
     /*
     * Get currently logged in user list of active sessions across different
     * devices.
     */
    public Call getSessions() {
        final String path = "/account/sessions";

        final Map<String, Object> params = Map.ofEntries(
        );



        final Map<String, String> headers = Map.ofEntries(
            entry("content-type", "application/json")
        );

        return client.call("GET", path, headers, params);
    }

     /// Create Account Session
     /*
     * Allow the user to login into his account by providing a valid email and
     * password combination. This route will create a new session for the user.
     */
    public Call createSession(String email, String password) {
        final String path = "/account/sessions";

        final Map<String, Object> params = Map.ofEntries(
            entry("email", email),
            entry("password", password)
        );



        final Map<String, String> headers = Map.ofEntries(
            entry("content-type", "application/json")
        );

        return client.call("POST", path, headers, params);
    }

     /// Delete All Account Sessions
     /*
     * Delete all sessions from the user account and remove any sessions cookies
     * from the end client.
     */
    public Call deleteSessions() {
        final String path = "/account/sessions";

        final Map<String, Object> params = Map.ofEntries(
        );



        final Map<String, String> headers = Map.ofEntries(
            entry("content-type", "application/json")
        );

        return client.call("DELETE", path, headers, params);
    }

     /// Create Account Session with OAuth2
     /*
     * Allow the user to login to his account using the OAuth2 provider of his
     * choice. Each OAuth2 provider should be enabled from the Appwrite console
     * first. Use the success and failure arguments to provide a redirect URL's
     * back to your app when login is completed.
     */
    public Call createOAuth2Session(String provider, String success, String failure, List scopes) {
        final String path = "/account/sessions/oauth2/{provider}".replace("{provider}", provider);

        final Map<String, Object> params = Map.ofEntries(
            entry("success", success),
            entry("failure", failure),
            entry("scopes", scopes),
            entry("project", client.getConfig().get("project"))
        );



        final Map<String, String> headers = Map.ofEntries(
            entry("content-type", "application/json")
        );

        return client.call("GET", path, headers, params);
    }

     /// Delete Account Session
     /*
     * Use this endpoint to log out the currently logged in user from all his
     * account sessions across all his different devices. When using the option id
     * argument, only the session unique ID provider will be deleted.
     */
    public Call deleteSession(String sessionId) {
        final String path = "/account/sessions/{sessionId}".replace("{sessionId}", sessionId);

        final Map<String, Object> params = Map.ofEntries(
        );



        final Map<String, String> headers = Map.ofEntries(
            entry("content-type", "application/json")
        );

        return client.call("DELETE", path, headers, params);
    }

     /// Create Email Verification
     /*
     * Use this endpoint to send a verification message to your user email address
     * to confirm they are the valid owners of that address. Both the **userId**
     * and **secret** arguments will be passed as query parameters to the URL you
     * have provider to be attached to the verification email. The provided URL
     * should redirect the user back for your app and allow you to complete the
     * verification process by verifying both the **userId** and **secret**
     * parameters. Learn more about how to [complete the verification
     * process](/docs/client/account#updateAccountVerification). 
     * 
     * Please note that in order to avoid a [Redirect
     * Attack](https://github.com/OWASP/CheatSheetSeries/blob/master/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.md)
     * the only valid redirect URLs are the ones from domains you have set when
     * adding your platforms in the console interface.
     */
    public Call createVerification(String url) {
        final String path = "/account/verification";

        final Map<String, Object> params = Map.ofEntries(
            entry("url", url)
        );



        final Map<String, String> headers = Map.ofEntries(
            entry("content-type", "application/json")
        );

        return client.call("POST", path, headers, params);
    }

     /// Complete Email Verification
     /*
     * Use this endpoint to complete the user email verification process. Use both
     * the **userId** and **secret** parameters that were attached to your app URL
     * to verify the user email ownership. If confirmed this route will return a
     * 200 status code.
     */
    public Call updateVerification(String userId, String secret) {
        final String path = "/account/verification";

        final Map<String, Object> params = Map.ofEntries(
            entry("userId", userId),
            entry("secret", secret)
        );



        final Map<String, String> headers = Map.ofEntries(
            entry("content-type", "application/json")
        );

        return client.call("PUT", path, headers, params);
    }
}