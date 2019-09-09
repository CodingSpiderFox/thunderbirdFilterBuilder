import java.io.File

    fun main() {

        var resultFile = File("result")
        var result: String = ""

        /**
         * version="9"
        logging="no"
        name="Subject contains: text"
        enabled="yes"
        type="17"
        action="Move to folder"
        actionValue="mailbox://nobody@Feeds/Trash"
        condition="OR (subject,contains,text) OR (body,contains,text)"
         */

        result = result.plus("version=9\n")
            .plus("logging=no\r\n")
            .plus("name=\"global\"\n")
            .plus("enabled=\"yes\"\n")
            .plus("type=\"17\"\n")
            .plus("action=\"Move to folder\"\n")
            .plus("actionValue=\"mailbox://nobody@Feeds/Thrash\"\n")
            .plus("condition=\"\n")

        File("input").forEachLine {
            result = result.plus("OR (subject,contains,)") + it + ") OR (body,contains," + it + ")\"\n"
        }

        resultFile.writeText(result)
    }