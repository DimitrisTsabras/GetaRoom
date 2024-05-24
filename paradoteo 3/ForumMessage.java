public class ForumMessage {
    //Class attributes
    private String message;
    private User user;


    // Constructor
    public ForumMessage(String message, User user) {
        this.message = message;
        this.user = user;
    }
}

// Getters and Setters For the Forum Use Case
public String getForumMessage() {
    return this.message;
}

public void setForumMessage(String message) {
    this.message = message;
}

public String getForumMessage() {
    return this.message;
}

public void setUser(User user) {
    this.user = user;
}

public String getUser() {
    return this.user;
}

public void showMessage() {
    if (messages.isEmpty()) {
        System.out.println("No messages to display.");
        return;
    }

    for (Message message : messages) {
        System.out.println(message.getUsername() + ": " + message.getMessage());
    }
}

public static void main(String[] args) {
    Forum forum = new Forum();

    // Adding some messages for testing
    forum.addMessage("user1", "Hello, this is a message!");
    forum.addMessage("user2", "This is another message.");

    // Display the messages
    forum.showMessage();
}
}

