del "C:\Programming\processingjava\Images\frame-00001.tif"
del "C:\Programming\processingjava\Images\video.mp4"
ffmpeg -i frame-%%05d.tif -start_number 00037 -r 25 -threads 4 video.mp4