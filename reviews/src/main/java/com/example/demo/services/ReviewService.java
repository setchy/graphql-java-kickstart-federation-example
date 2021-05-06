/*
 * Copyright 2020 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.demo.services;

import com.example.demo.model.Review;
import com.example.demo.model.Show;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    public List<Review> getReviews(Show show) {
        List<Review> reviews = new ArrayList<Review>();
        reviews.add(new Review(1));
        reviews.add(new Review(5));
        reviews.add(new Review(4));
        reviews.add(new Review(3));

        return reviews;
    }
}