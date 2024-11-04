The DNF (Dutch National Flag) algorithm was developed by Edsger W. Dijkstra. This algorithm is primarily used to sort elements in an array into three different groups, typically representing three distinct values. A classic example involves sorting the numbers 0, 1, and 2.

How the Algorithm Works:
```
FUNCTION DNF(colors)
    SET low = 0
    SET high = LENGTH(colors) - 1
    SET mid = 0

    WHILE mid <= high DO
        SWITCH colors[mid] DO
            CASE 0:
                CALL swap_to_numbers(colors, low, mid)
            CASE 1:
                INCREMENT mid
            CASE 2:
                CALL swap_to_numbers(colors, mid, high)
            DEFAULT:
                THROW AssertionError
        END SWITCH
    END WHILE
END FUNCTION
```