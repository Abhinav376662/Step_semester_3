public class Character {
    private int health;
    private final int maxHealth;
    
    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth; // Start at full health
    }
    
    public void takeDamage(int amount) {
        if (amount > 0) {
            health = health - amount;
            if (health < 0) {
                health = 0; // Floor at 0
            }
        }
    }
    
    public void heal(int amount) {
        if (amount > 0) {
            health = health + amount;
            if (health > maxHealth) {
                health = maxHealth; // Cap at maximum
            }
        }
    }
    
    public int getHealth() {
        return health;
    }
    
    public int getMaxHealth() {
        return maxHealth;
    }
}
