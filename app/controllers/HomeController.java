package controllers;

import io.ebean.Ebean;
import io.ebean.RawSqlBuilder;
import io.ebean.SqlRow;
import models.Book;
import play.libs.Json;
import play.mvc.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(views.html.index.render());
    }

    public Result showForm() {
        return ok(views.html.form.render());
    }

    public Result handleForm() {
        return ok("handle");
    }

    /*public Result getBookListAsJson1() {
        List<Book> bookList = Ebean.find(Book.class).findList();
        List<String> bookNames = bookList.stream().map(book -> book.name).collect(Collectors.toList());
        return ok(Json.toJson(bookNames));
    }*/

    public Result getBookListAsJson() {
        List<SqlRow> rows = Ebean.createSqlQuery("select * from book").findList();
        List<String> bookNames = rows.stream().map(row -> row.getString("name")).collect(Collectors.toList());
        return ok(Json.toJson(bookNames));
    }

}
