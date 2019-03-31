package com.larreaf.macowins;

import java.util.List;

public class Conversor {
	public static String itemsToString(List<Item>  items) {
		return items.stream().map(item -> "\n\t\t→ " + item.toString()).reduce("", (a,b) -> a + b);
	}
}
