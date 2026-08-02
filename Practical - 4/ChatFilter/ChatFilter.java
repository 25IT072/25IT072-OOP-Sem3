public class ChatFilter {
    public static String filter(String[] logs, String key){
        StringBuilder report = new StringBuilder();
        int count = 0;
        for(String line : logs){
            String[] part = line.split(" ", 3);

            if(part.length < 3) continue;

            String time = part[0];
            String user = part[1];
            String message = part[2];

            if(message.toLowerCase().contains(key.toLowerCase())){
                count++;
                report.append(time).append(" ").append(user)
                      .append(": ").append(message).append("\n");
            }
        }
        return "Matches: " + count + "\n" + report.toString();
    }
}

