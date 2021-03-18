package dev.lyze.gamejammarch2021.lyze.setup;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.utils.*;
import dev.lyze.gamejammarch2021.utils.Tuple;
import lombok.var;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class BodyPart
{
    private final Texture texture;

    private final TextureAtlas atlas = new TextureAtlas();

    public BodyPart(FileHandle jsonFile)
    {
        texture = new Texture(jsonFile.parent().child(jsonFile.nameWithoutExtension() + ".png"));

        var json = new JsonReader().parse(jsonFile);

        var frameList = json.get("frameList");
        if (frameList == null)
            generateAtlas(generateGridMapping(json));
        else
            generateAtlasFromList(frameList);
    }

    private HashMap<String, ArrayList<Tuple<Integer, TextureRegion>>> generateGridMapping(JsonValue json)
    {
        var frameGrid = json.get("frameGrid");

        var sizes = frameGrid.get("size").asIntArray();
        var size = new GridPoint2(sizes[0], sizes[1]);

        var names = frameGrid.get("names");

        var mapping = new HashMap<String, ArrayList<Tuple<Integer, TextureRegion>>>();

        for (int y = 0; y < names.size; y++)
        {
            var entriesInRow = names.get(y).asStringArray();
            for (int x = 0; x < entriesInRow.length; x++)
            {
                var entry = entriesInRow[x];
                if (entry == null)
                    continue;

                var entryArray = entry.split("\\.");
                var entryName = entryArray[0];
                var entryIndex = entryArray.length == 1 ? 1 : Integer.parseInt(entryArray[1]);

                mapping.putIfAbsent(entryName, new ArrayList<>());

                mapping.get(entryName).add(new Tuple<>(entryIndex, new TextureRegion(texture, x * size.x, y * size.y, size.x, size.y)));
            }
        }

        setupAliases(json, mapping);

        return mapping;
    }

    private void setupAliases(JsonValue json, HashMap<String, ArrayList<Tuple<Integer, TextureRegion>>> map)
    {
        var aliases = json.get("aliases");

        var alias = aliases.child;
        while (alias != null) {
            var aliasArray = alias.name.split("\\.");
            var aliasName = aliasArray[0];
            var aliasIndex = Integer.parseInt(aliasArray[1]);

            var targetArray = alias.asString().split("\\.");
            var targetName = targetArray[0];
            var targetIndex = Integer.parseInt(targetArray[1]);

            if (!map.containsKey(aliasName))
                map.put(aliasName, new ArrayList<>());

            map.get(aliasName).add(new Tuple<>(aliasIndex,
                    map.get(targetName)
                            .stream()
                            .filter(t -> t.getItem1() == targetIndex)
                            .findFirst()
                            .get()
                            .getItem2()));

            alias = alias.next;
        }
    }

    private void generateAtlas(HashMap<String, ArrayList<Tuple<Integer, TextureRegion>>> mapping)
    {
        for (String animationName : mapping.keySet())
        {
            var animations = mapping.get(animationName);
            animations.sort(Comparator.comparingInt(Tuple::getItem1));

            for (Tuple<Integer, TextureRegion> index : animations)
                atlas.addRegion(animationName, index.getItem2());
        }
    }

    private void generateAtlasFromList(JsonValue frameList)
    {
        var name = frameList.child;

        var mapping = new HashMap<String, ArrayList<Tuple<Integer, TextureRegion>>>();

        while (name != null) {
            var dimension = name.asIntArray();

            var entryArray = name.name.split("\\.");
            var entryName = entryArray[0];
            var entryIndex = entryArray.length == 1 ? 1 : Integer.parseInt(entryArray[1]);

            mapping.putIfAbsent(entryName, new ArrayList<>());

            mapping.get(entryName).add(new Tuple<>(entryIndex, new TextureRegion(texture, dimension[0], dimension[1], dimension[2] - dimension[0], dimension[3] - dimension[1])));

            name = name.next;
        }

        generateAtlas(mapping);
    }

    public Array<TextureRegion> generateAnimation(String region, int... indexes) {
        var animation = new Array<TextureRegion>();
        var regions = atlas.findRegions(region);

        for (int index : indexes)
            animation.add(regions.get(index - 1));

        return animation;
    }

    public TextureAtlas getAtlas()
    {
        return atlas;
    }
}
