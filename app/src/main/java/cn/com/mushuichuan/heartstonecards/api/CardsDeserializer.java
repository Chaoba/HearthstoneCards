package cn.com.mushuichuan.heartstonecards.api;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import cn.com.mushuichuan.heartstonecards.mvp.model.Card;
import cn.com.mushuichuan.heartstonecards.util.CLogger;

public class CardsDeserializer implements JsonDeserializer<List<Card>> {

    @Override
    public List<Card> deserialize(JsonElement je, Type typeOfT,
                                  JsonDeserializationContext context) throws JsonParseException {

        Type listType = new TypeToken<List<Card>>() {}.getType();

        List<Card> cards = null;
        try {
            cards = new Gson().fromJson(je, listType);
        } catch (JsonSyntaxException e) {
            CLogger.e(e);
        }
        return cards;
    }
}