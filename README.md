# CoinsAPI-NK
CoinsAPI for Nukkit

# Commands
Command | Description | use
--- | --- | ---
`/setcoin` | Set Coins Player | op
`/addcoin` | Add Coins Player | op
`/reducecoin` | Reduce Coins Player | op
`/seecoin` | See Coins Player | all
`/mycoin` | Check My Coins | all

# Repository
```xml
<repositories>
        <repository>
                <id>jitpack.io</id>
                <url>https://jitpack.io</url>
        </repository>
</repositories>
```

# Dependency
```xml
<dependency>
        <groupId>com.github.angga7togk</groupId>
        <artifactId>CoinsAPI-NK</artifactId>
        <version>1.0.0</version>
</dependency>
```

# For Developer
```java
// get coins people or yourself
Coins.getInstance().getPlayerCoins(player);
Coins.getInstance().getPlayerCoinsByName("Angga7Togk");

// Set Coins Player
Coins.getInstance().getCoinsManager().setCoins(player, 100);
Coins.getInstance().getCoinsManager().setCoinsByName("Angga7Togk", 100);
        
// Add Coins Player
Coins.getInstance().getCoinsManager().addCoins(player, 125);
Coins.getInstance().getCoinsManager().addCoinsByName("Angga7Togk", 125);

// Reduce Coins Player
Coins.getInstance().getCoinsManager().reduceCoins(player, 25);
Coins.getInstance().getCoinsManager().reduceCoinsByName("Angga7Togk", 25);
```
