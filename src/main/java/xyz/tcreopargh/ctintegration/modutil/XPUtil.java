package xyz.tcreopargh.ctintegration.modutil;

import com.google.common.math.BigIntegerMath;
import com.google.common.math.LongMath;
import net.minecraft.entity.player.EntityPlayer;

import javax.annotation.Nonnull;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * Credit to <a href="https://github.com/SleepyTrousers/EnderIO">EnderIO</a> for writing all of the code below.
 * @see <a href="https://github.com/SleepyTrousers/EnderIO/blob/master/enderio-base/src/main/java/crazypants/enderio/base/xp/XpUtil.java">XpUtil</a>
 */
public class XPUtil {

    private static final BigInteger B72 = BigInteger.valueOf(72);
    private static final BigInteger B54215 = BigInteger.valueOf(54215);
    private static final BigInteger B325 = BigInteger.valueOf(325);
    private static final BigInteger B18 = BigInteger.valueOf(18);
    private static final long LVLOFFSET32 = -calculateXPfromLevelHigh(32) + calculateXPfromLevelLow(32);

    public static long termial(long level) {
        // ∑ 0 ... level
        return (level * level + level) / 2L;
    }

    private static long calculateXPfromLevelHigh(int level) {
        return -158L * (level + 1L) + termial(level - 1) * 9L; // correct in long, but offset by LVLOFFSET32
    }

    private static long calculateXPfromLevelLow(int level) {
        if (level >= 1 && level <= 16) {
            return (long) (Math.pow(level, 2) + 6 * level);
        } else if (level >= 17 && level <= 31) {
            return (long) (2.5 * Math.pow(level, 2) - 40.5 * level + 360);
        } else if (level >= 32) {
            return (long) (4.5 * Math.pow(level, 2) - 162.5 * level + 2220); // bad formula in long
        } else {
            return 0;
        }
    }

    private static long calculateXPfromLevel(int level) {
        if (level >= 32) {
            return calculateXPfromLevelHigh(level) + LVLOFFSET32;
        } else {
            return calculateXPfromLevelLow(level);
        }
    }

    public static int getExperienceForLevel(int level) {
        if (level < 0) {
            throw new ArithmeticException("level underflow");
        }
        return Math.toIntExact(calculateXPfromLevel(level));
    }


    public static int getPlayerXP(@Nonnull EntityPlayer player) throws ArithmeticException {
        try {
            return player.capabilities.isCreativeMode ? Integer.MAX_VALUE / 2
                    : Math.addExact(getExperienceForLevel(player.experienceLevel), (int) (player.experience * player.xpBarCap()));
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Too many XP levels");
        }
    }

    public static void addPlayerXP(@Nonnull EntityPlayer player, int amount) throws ArithmeticException {
        try {
            int experience = Math.max(0, Math.addExact(getPlayerXP(player), amount));
            player.experienceTotal = experience;
            player.experienceLevel = getLevelForExperience(experience);
            int expForLevel = getExperienceForLevel(player.experienceLevel);
            player.experience = (float) (experience - expForLevel) / (float) getXpBarCapacity(player.experienceLevel);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Too many XP levels");
        }
    }

    public static int getXpBarCapacity(int level) {
        if (level >= 30) {
            return -158 + level * 9;
        } else if (level >= 15) {
            return -38 + level * 5;
        } else if (level >= 0) {
            return 7 + level * 2;
        } else {
            throw new ArithmeticException("level underflow");
        }
    }

    public static int getLevelForExperience(long exp) {
        if (exp > Long.MAX_VALUE / 72) {
            return BigIntegerMath.sqrt(BigInteger.valueOf(exp).multiply(B72).subtract(B54215), RoundingMode.DOWN).add(B325).divide(B18).intValueExact();
        }
        if (exp > Integer.MAX_VALUE) {
            return (int) ((LongMath.sqrt(72 * exp - 54215, RoundingMode.DOWN) + 325) / 18);
        }
        if (exp > 1395) {
            return (int) ((Math.sqrt(72 * exp - 54215) + 325) / 18);
        }
        if (exp > 315) {
            return (int) (Math.sqrt(40 * exp - 7839) / 10 + 8.1);
        }
        if (exp > 0) {
            return (int) (Math.sqrt(exp + 9) - 3);
        }
        return 0;
    }
}
