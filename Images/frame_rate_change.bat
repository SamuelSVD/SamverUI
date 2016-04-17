echo "input: " %1 "output: " %2 "factor: " %3
ffmpeg -i %1 -vf "setpts=(1/%3)*PTS" %2